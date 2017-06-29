package nz.co.midori.frontend.controllers;

import nz.co.midori.backend.core.exceptions.ResourceNotFoundException;
import nz.co.midori.backend.core.model.ApplicationUser;
import nz.co.midori.backend.core.model.User;
import nz.co.midori.backend.core.model.UserRoleType;
import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.backend.core.services.SecurityService;
import nz.co.midori.backend.core.services.UserAuthentication;
import nz.co.midori.backend.core.services.UserService;
import nz.co.midori.backend.core.exceptions.ForbiddenException;
import nz.co.midori.backend.core.validators.ApplicationUserValidator;
import nz.co.midori.frontend.model.CustomUserDetails;
import nz.co.midori.frontend.model.ResetPassword;
import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * Created by djunigari on 13/05/17.
 */
@Controller
public class UserController {
    private Logger log = Logger.getLogger("UserController");

    @Value("${app.security.crypto.key_reset_password_user}")
    public String KEY_RESET_PASSWORD_USER;
    private @Autowired
    AutowireCapableBeanFactory beanFactory;

    @Autowired
    private UserService service;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserAuthentication authentication;

    @Autowired
    private UserRepository repository;

    @GetMapping("/user")
    public String registerUserPage() {
        return "/public/user/index";
    }
    @GetMapping("/user/forgotten-password")
    public String forgottenPassword(){
        return "/public/user/forgotten-password";
    }
    @GetMapping("/user/reset-password-email")
    public String resetPasswordEmail(@RequestParam(value = "email", required = true) String email) throws UnsupportedEncodingException {
        service.resetPasswordEmail(email);
        return "redirect:/login";
    }

    @GetMapping("/private/user/{id}")
    private ModelAndView getUserAuthenticatedPage(@PathVariable("id") long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if(principal instanceof CustomUserDetails) {
            if(((CustomUserDetails) principal).getUser().getUserId() == id || auth.getAuthorities().contains(new SimpleGrantedAuthority(UserRoleType.Admin.toString()))){
                User user = repository.find(id);
                return new ModelAndView("/authenticated/user/index","user",user);
            }
        }
        throw new ForbiddenException();
    }

    @GetMapping("/user/{id}/activate")
    public ModelAndView getActivatePage(@PathVariable("id") long id,
                                        @RequestParam(value = "code",required = true) String code) throws UnsupportedEncodingException, DecoderException {
        authentication.activateUserAccount(id, code);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/user/{id}/reset-password")
    public ModelAndView userActions(@PathVariable("id") long id,
                                    @RequestParam(value = "code",required = false) String code){
        User user = service.getUserByCode(code,KEY_RESET_PASSWORD_USER);
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(true);
        if(user == null){
            throw new ResourceNotFoundException();
        }
        if(user.getUserId() != id){
            throw new ForbiddenException();
        }

        return new ModelAndView( "/public/user/reset-password")
                .addObject("id",id)
                .addObject("code",code);
    }

    @PostMapping("/user")
    public ModelAndView registerUser(@Valid ApplicationUser user, BindingResult result, ModelMap modelMap) throws UnsupportedEncodingException {
        ApplicationUserValidator validator = new ApplicationUserValidator();
        beanFactory.autowireBean(validator);
        validator.validate(user,result);
        if(result.hasErrors()) {
            modelMap.put(BindingResult.class.getName() + ".user", result);
            return new ModelAndView( "/public/user/index","user",user);
        }
        service.createUser(user);
        return new ModelAndView( "/public/user/confirm-your-email","user",user);
    }

    @PostMapping("/private/user/{id}/reset-password")
    public ModelAndView resetPassword(
            @PathVariable("id") long id,
            @RequestParam(value = "code", required = true)String code,
            @Valid ResetPassword resetPassword, BindingResult result){

        if(!resetPassword.getPasswordConfirmation().equals(resetPassword.getPassword())){
            result.addError(new FieldError("resetPassword","passwordConfirmation","Confirm Password is different"));
        }
        if(result.hasErrors()) {
            return new ModelAndView( "/public/user/reset-password")
                    .addObject("id",id)
                    .addObject("code",code);
        }
        service.resetPassword(id,code,resetPassword.getPassword());
        return new ModelAndView("redirect:/login");
    }
}


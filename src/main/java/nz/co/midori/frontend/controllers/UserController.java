package nz.co.midori.frontend.controllers;

import nz.co.midori.backend.core.model.ApplicationUser;
import nz.co.midori.backend.core.model.User;
import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.backend.core.services.UserAuthentication;
import nz.co.midori.backend.core.services.UserService;
import nz.co.midori.frontend.model.ResetPassword;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * Created by djunigari on 13/05/17.
 */
@Controller
public class UserController {
    private Logger log = Logger.getLogger("UserController");
    public static final String RESET_USER_PASSWORD = "resetUserPassword";

    @Autowired
    private UserService service;

    @Autowired
    private UserAuthentication authentication;

    @Autowired
    private UserRepository repository;

    @GetMapping("/register/user")
    public String registerUserPage(){
        return "/register/user/create";
    }

    @PostMapping("/register/user")
    public String registerUser(@Valid ApplicationUser user, BindingResult result, Model model) throws UnsupportedEncodingException {
        model.addAttribute(user);
        if(repository.finUserByEmail(user.getEmail()) != null){
            result.addError(new FieldError("user","email","E-mail existent"));
        }
        if(repository.findUserByUserName(user.getUserName()) != null){
            result.addError(new FieldError("user","userName","Username existent"));
        }
        if(!user.getPasswordConfirmation().equals(user.getPassword())){
            result.addError(new FieldError("user","passwordConfirmation","Confirm Password is different"));
        }
        if(result.hasErrors()) {
            return "/register/user/create";
        }
        service.createUser(user);
        return "/register/user/confirm-your-email";
    }

    @GetMapping("/register/user/activate")
    public String activateUser(@RequestParam(value="code", required=true) String code) throws DecoderException, UnsupportedEncodingException {
        String[] s = code.split("_");
        if(!service.getCodeToken(s[0],UserService.KEY_ACTIVATE_USE).equals(s[1])){
            return "/error/404";
        }
        byte[] bytes = Hex.decodeHex(s[0].toCharArray());
        User user = new User();
        user.setEmail(new String(bytes, "UTF-8"));
        authentication.activateUserAccount(user);
        return "redirect:/login";
    }

    @GetMapping("/forgotten-password")
    public String forgottenPassword(){
        return "/register/user/forgotten-password";
    }

    @PostMapping("/forgotten-password")
    public String forgottenPassword(String email) throws UnsupportedEncodingException {
        ApplicationUser user = repository.finUserByEmail(email);
        if(user != null){
            service.forgottenPassword(user);
        }
        return "redirect:/login";
    }

    @GetMapping("/register/user/reset-password")
    public String requestToResetPassword(@RequestParam(value="code", required=true) String code, HttpSession session) throws DecoderException, UnsupportedEncodingException {
        String[] s = code.split("_");
        if(!service.getCodeToken(s[0],UserService.KEY_RESET_PASSWORD_USER).equals(s[1])){
            return "/error/404";
        }
        byte[] bytes = Hex.decodeHex(s[0].toCharArray());
        String userName = new String(bytes, "UTF-8");

        User user = repository.findUserByUserName(userName);
        if(user == null){
            log.info("Task: requestToResetPassword, Result: Failed, ERROR_MESSAGE: User not exist with userName="+userName);
            return "/error/404";
        }
        session.setAttribute(RESET_USER_PASSWORD, user);
        return "/register/user/reset-password";
    }

    @PostMapping("/register/user/reset-password")
    public String resetPassword(@Valid ResetPassword resetPassword, BindingResult result, HttpSession session){
        User user = (User)session.getAttribute(RESET_USER_PASSWORD);
        if(user == null){
            log.info("Task: resetPassword, Result: Failed, ERROR_MESSAGE: User not exist");
            return "/error/404";
        }
        if(!resetPassword.getPasswordConfirmation().equals(resetPassword.getPassword())){
            result.addError(new FieldError("resetPassword","passwordConfirmation","Confirm Password is different"));
        }
        if(result.hasErrors()) {
            return "/register/user/reset-password";
        }
        user.setPassword(resetPassword.getPassword());
        repository.updateUser(user);
        session.removeAttribute(RESET_USER_PASSWORD);
        session.setAttribute(LoginController.USER_SESSION,user);
        log.info("Task: resetPassword, Result: Success, User="+user);
        return "redirect:/";
    }
}


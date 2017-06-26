package nz.co.midori.frontend.controllers;

import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.backend.core.services.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by djunigari on 12/05/17.
 */
@Controller
public class LoginController {
    @Value("app.security.login.session.user")
    public String USER_SESSION;

    @Autowired
    private UserAuthentication authentication;
    @Autowired
    private UserRepository repository;

    @GetMapping("/login")
    public String loginPage(HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            return "redirect:/";
        }
        return "/public/login/index";
    }

}

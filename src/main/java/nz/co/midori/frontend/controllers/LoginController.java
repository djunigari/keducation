package nz.co.midori.frontend.controllers;

import nz.co.midori.backend.core.model.User;
import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.backend.core.services.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * Created by djunigari on 12/05/17.
 */
@Controller
public class LoginController {
    public static final String USER_SESSION = "user";
    public static final String USER_COOKIE = "token";
    private Logger log = Logger.getLogger("LoginController");

    @Autowired
    private UserAuthentication authentication;
    @Autowired
    private UserRepository repository;

    @GetMapping("/login")
    public String loginPage(HttpSession session){
        if(session.getAttribute(USER_SESSION) != null) {
            return "redirect:/";
        }
        return "/login/index";
    }

    @PostMapping("/login")
    public String authenticUser(User user,boolean keepLogged, HttpSession session,HttpServletRequest request, HttpServletResponse resp){
        String referer = request.getHeader("Referer");
        if(authentication.authenticateUserByEmailAndPassword(user.getEmail(),user.getPassword()))
        {
            user = repository.finUserByEmail(user.getEmail());
            session.setAttribute(USER_SESSION, user);
            if(keepLogged){
                Cookie cookie = new Cookie(LoginController.USER_COOKIE, user.getUserName());
                cookie.setMaxAge(Integer.MAX_VALUE);
                resp.addCookie(cookie);
            }
            log.info("Task: authenticUser, Result: Success, User= "+ user.toString());
            if(referer.endsWith("/connect/facebook")){
                return "redirect:/";
            }
            return "redirect:"+referer;
        }
        log.info("Task: authenticUser, Result: Failed, User= "+ user.toString());
        return "/login/index";
    }

    @GetMapping("/logout")
    public String authenticUser(HttpSession session, HttpServletResponse resp){
        session.invalidate();
        Cookie cookie = new Cookie(LoginController.USER_COOKIE, "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        return "redirect:/login";
    }
}

package nz.co.midori.frontend.interceptors;

import nz.co.midori.backend.core.model.User;
import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.frontend.controllers.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by djunigari on 11/06/17.
 */
@Component
public class ApplicationUserLoggedInterceptor implements HandlerInterceptor{
    private Logger log = Logger.getLogger("ApplicationUserLoggedInterceptor");

    @Autowired
    private UserRepository repository;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        User user = (User)req.getSession().getAttribute(LoginController.USER_SESSION);
        if (user == null) {
            String token = null;
            if(req.getCookies() != null){
                for(Cookie c : req.getCookies()){
                    if(c.getName().equals(LoginController.USER_COOKIE)){
                        token = c.getValue();
                        log.info("Task: foundUserCookie, Result: Success, USER_COOKIE= "+ token);
                        break;
                    }
                }
            }
            if (token != null) {
                user = repository.findUserByUserName(token);
                Cookie cookie = new Cookie(LoginController.USER_COOKIE, user.getUserName());

                if (user != null) {
                    req.getSession().setAttribute(LoginController.USER_SESSION, user); // Login.
                    cookie.setMaxAge(Integer.MAX_VALUE);
                    log.info("Task: addUserCookie, Result: Success, USER_COOKIE= "+ cookie.getName());
                } else {
                    cookie.setMaxAge(0);
                    log.info("Task: removedUserCookie, Result: Success, USER_COOKIE= "+ cookie.getName());
                }
                resp.addCookie(cookie);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

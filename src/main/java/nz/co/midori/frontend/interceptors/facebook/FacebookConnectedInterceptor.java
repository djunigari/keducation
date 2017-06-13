package nz.co.midori.frontend.interceptors.facebook;

import nz.co.midori.backend.core.converters.FacebookProfileToFacebookUserConverter;
import nz.co.midori.backend.core.model.FacebookUser;
import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.frontend.controllers.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by djunigari on 10/06/17.
 */

@Component
public class FacebookConnectedInterceptor implements HandlerInterceptor {
    private Logger log = Logger.getLogger("FacebookConnectedInterceptor");
    @Autowired
    private UserRepository repository;
    @Autowired
    private Facebook facebook;
    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (connectionRepository.findPrimaryConnection(Facebook.class) != null) {
            FacebookUser facebookUser = repository.findByFacebookId(facebook.userOperations().getUserProfile().getId());
            if(facebookUser == null){
                facebookUser = new FacebookProfileToFacebookUserConverter().converter(facebook.userOperations().getUserProfile());
                repository.createFacebookUser(facebookUser);
            }
            if(req.getSession().getAttribute(LoginController.USER_SESSION)==null) {
                req.getSession().setAttribute(LoginController.USER_SESSION, facebookUser);
            }
            return true;
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

package nz.co.midori.frontend.interceptors.facebook;

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
public class FacebookDisconnectedInterceptor implements HandlerInterceptor {
    private Logger log = Logger.getLogger("FacebookDisconnectedInterceptor");

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if(req.getMethod().equals("DELETE") && req.getParameter("_method").equals("delete")){
            req.getSession().invalidate();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

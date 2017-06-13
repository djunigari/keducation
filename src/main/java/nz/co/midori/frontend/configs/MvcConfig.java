package nz.co.midori.frontend.configs;

import nz.co.midori.frontend.interceptors.ApplicationUserLoggedInterceptor;
import nz.co.midori.frontend.interceptors.facebook.FacebookDisconnectedInterceptor;
import nz.co.midori.frontend.interceptors.facebook.FacebookConnectedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private ApplicationUserLoggedInterceptor applicationUserLoggedInterceptor;
    @Autowired
    private FacebookConnectedInterceptor facebookConnectedInterceptor;
    @Autowired
    private FacebookDisconnectedInterceptor facebookDisconnectedInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/agentLists").setViewName("agentLists");
        registry.addViewController("/agentRegister").setViewName("agentRegister");
        registry.addViewController("/review").setViewName("review");
        registry.addViewController("/school").setViewName("school");
        registry.addViewController("/school3").setViewName("school3");
        registry.addViewController("/school").setViewName("schoolLists");
        registry.addViewController("/schoolRegister").setViewName("schoolRegister");
        registry.addViewController("/summaryReview").setViewName("summaryReview");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(facebookDisconnectedInterceptor).addPathPatterns("/connect/facebook");
        registry.addInterceptor(facebookConnectedInterceptor).addPathPatterns("/connect/facebook");
        registry.addInterceptor(applicationUserLoggedInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }
}

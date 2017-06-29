package nz.co.midori.frontend.configs;

import nz.co.midori.frontend.interceptors.facebook.FacebookDisconnectedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private FacebookDisconnectedInterceptor facebookDisconnectedInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/about").setViewName("/public/about");
        registry.addViewController("/agentLists").setViewName("/public/agentLists");
        registry.addViewController("/agentRegister").setViewName("/public/agentRegister");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(facebookDisconnectedInterceptor).addPathPatterns("/connect/facebook");
    }




    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }
}

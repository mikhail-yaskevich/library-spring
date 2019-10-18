package by.it.training.library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"by.it.training.library.controller"})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        System.out.println("configureViewResolvers");
        registry.jsp("/WEB-INF/pages/", ".jsp");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("addViewControllers");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("addResourceHandlers");
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}

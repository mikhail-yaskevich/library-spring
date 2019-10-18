package by.it.training.library.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("getRootConfigClasses");
        return new Class[]{HibernateConfig.class, WebSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("getServletConfigClasses");
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("getServletMappings");
        return new String[]{"/"};
    }
}

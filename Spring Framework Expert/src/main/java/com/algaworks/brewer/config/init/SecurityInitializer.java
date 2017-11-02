package com.algaworks.brewer.config.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.SessionTrackingMode;
import java.util.EnumSet;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {


    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {

//        servletContext.getSessionCookieConfig().setMaxAge(20); - Tempo máximo da sessão, independente de o usuário está usando ou não.
        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));

        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter",
                new CharacterEncodingFilter());

        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}

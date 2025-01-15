package com.idv.demo.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class MessageSourceConfig {

    @Bean
    public ResourceBundleMessageSource messageSource () {
        ResourceBundleMessageSource  source  =  new  ResourceBundleMessageSource ();
        source.setBasenames( "i18n/messages" );
        source.setDefaultEncoding( "UTF-8" );
        source.setUseCodeAsDefaultMessage( true );
        source.setCacheSeconds( 3600 );
        return source;
    }
}

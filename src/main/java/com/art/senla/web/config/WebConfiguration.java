package com.art.senla.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class WebConfiguration {
    @Value("message")
    private String baseName;
    @Value("UTF-8")
    private String encoding;
    @Value("ru")
    private String languageRu;
    @Value("en")
    private String languageEn;

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(baseName);
        messageSource.setDefaultEncoding(encoding);
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    @Bean(name = "localeResolver")
    public LocaleResolver devLocaleResolver() {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(new Locale(languageRu));
        return acceptHeaderLocaleResolver;
    }
}

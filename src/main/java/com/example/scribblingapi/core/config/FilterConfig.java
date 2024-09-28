package com.example.scribblingapi.core.config;

import com.example.scribblingapi.core.filter.UrlValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new UrlValidationFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(0);
        return bean;
    }
}

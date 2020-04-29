package com.lzy.webmvc.encodingFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;


@Configuration
public class CharterEncodingConfig {

    @Bean("encodingFilter")
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        registrationBean.setFilter(encodingFilter);
        registrationBean.addUrlPatterns("/hello/encoding");
        return registrationBean;
    }

}

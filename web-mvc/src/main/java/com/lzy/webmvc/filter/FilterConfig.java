package com.lzy.webmvc.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>(new MyFilter());
        registrationBean.addUrlPatterns("/myFilter/**");
        return registrationBean;
    }
}

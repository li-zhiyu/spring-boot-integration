package com.lzy.springboot.config;

import com.lzy.springboot.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Myconfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/loginerror/**");
    }

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}

package com.lzy.webmvc.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new MyServlet(),"/Myservlet");
        return registrationBean;
    }
}

package com.lzy.webmvc.servlet;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 另外一种方式：通过继承WebApplicationInitializer也可以完成Servlet的注册，应为WebApplicationInitializer的所有实现类会在Servlet容器启动时候执行
 */
public class MyServletRegister implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        ServletRegistration.Dynamic myservlet = servletContext.addServlet("myservlet", MyServlet.class);
        myservlet.addMapping("/myServlet");
        myservlet.setLoadOnStartup(1);

    }
}

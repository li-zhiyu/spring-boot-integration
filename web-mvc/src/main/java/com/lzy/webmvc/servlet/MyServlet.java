package com.lzy.webmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 相当于：
 * <servlet>
 * 		<servlet-name>KafkaServlet</servlet-name>
 * 		<servlet-class>com.cmdrawin.pdm.service.flowable.kafka.KafkaServlet</servlet-class>
 * 		<load-on-startup>1</load-on-startup>
 * 	</servlet>
 * 	<servlet-mapping>
 * 		<servlet-name>KafkaServlet</servlet-name>
 * 		<url-pattern>/kafka/*</url-pattern>
 * 	</servlet-mapping>
 *
 * <load-on-startup>1</load-on-startup>的作用
 * 1)load-on-startup元素标记容器是否在启动的时候就加载这个servlet(实例化并调用其init()方法)。
 * 2)它的值必须是一个整数，表示servlet应该被载入的顺序
 * 3)当值为0或者大于0时，表示容器在应用启动时就加载并初始化这个servlet；
 * 4)当值小于0或者没有指定时，则表示容器在该servlet被选择时才会去加载。
 * 5)正数的值越小，该servlet的优先级越高，应用启动时就越先加载。
 * 6)当值相同时，容器就会自己选择顺序来加载。
 *
 * 注入一个自定义的servlet的两种方式：
 * 1）注解方式——在servlet上添加注解@WebServlet(urlPatterns="/myServlet",loadOnStartup=1)，然后在主动启动类上添加@ServletComponentScan(basePackages = "com.lzy.javastudy.servlet")
 * 2）ServletRegistrationBean方式——在@Configuration类中注入ServletRegistrationBean；
 * 3）servletContext.addServlet（）方式
 */
//@WebServlet(urlPatterns="/myServlet",loadOnStartup=1)
public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hello,servlet");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    @Override
    public void init() throws ServletException {
        super.init();

    }
}

package com.lzy.webmvc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ContollerAop {

    @Pointcut("execution(protected * com.lzy.webmvc.servlet.MyServlet.*(..))")
    public void funcPoint(){

    }

    @Before("funcPoint()")
    public void doBefore(){
        System.out.println("方法执行前。。。。");
    }

    @Before("funcPoint()")
    public void doAfter(){
        System.out.println("方法执行后。。。。");
    }

}

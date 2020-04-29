package com.lzy.webthymeleaf.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ContollerAop {

    @Pointcut("execution(** com.lzy.webthymeleaf.controller.*.*(..))")
    public void funcPoint(){

    }

    @Before("funcPoint()")
    public void doBefore(){
        System.out.println("方法执行前。。。。");
    }

    @After("funcPoint()")
    public void doAfter(){
        System.out.println("方法执行后。。。。");
    }

    @Around("funcPoint()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        System.out.println("方法环绕前。。。。");
        Object result=null;
        try {
             result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("方法环绕后。。。。");

        return result;

    }

}

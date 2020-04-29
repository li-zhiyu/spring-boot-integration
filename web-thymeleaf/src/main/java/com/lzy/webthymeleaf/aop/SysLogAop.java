package com.lzy.webthymeleaf.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Aspect
@Order(1)
public class SysLogAop {

    private static final Logger log = LoggerFactory.getLogger(SysLogAop.class);

    private ObjectMapper objectMapper;

    @Pointcut("@annotation(com.lzy.webthymeleaf.aop.SysLog)")
    public void funcPoint(){

    }


    @Around("funcPoint()")
    public Object doAround(ProceedingJoinPoint joinPoint){

        Long start= System.currentTimeMillis();

        Object result=null;
        try {
             result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        Long time=System.currentTimeMillis()-start;

        printLog(joinPoint,time);

        return result;

    }

    public void printLog(ProceedingJoinPoint joinPoint,Long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog annotation = method.getAnnotation(SysLog.class);
        String methodName = method.getName();
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getTarget().getClass().getName();
        log.info("操作：{}",annotation.value());
        log.info("请求方法：{}",name+"."+methodName+"()");
        //log.info("请求参数：{}",objectMapper.writeValueAsString(args));
        log.info("请求时间：{}", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        log.info("消耗时间：{}",time);
    }

}

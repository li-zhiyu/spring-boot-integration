package com.lzy.dubboprovider.aop;

import cn.hutool.json.JSONUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 *统一日志处理切面
 */
@Aspect
@Component
@Order(1)
public class DaologAspect{

    private static final Logger LOGGER = LoggerFactory.getLogger(DaologAspect.class);

    @Pointcut("execution(public * com.lzy.dubboprovider.dao.*.*(..))")//定义切点，即切入的方法
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(){
        /**
         * 需要在切入点之前执行的逻辑
         */
        LOGGER.info("切点执行之前，开始时间："+System.currentTimeMillis());
    }

    @After("pointcut()")
    public void doAfter(){
        /**
         * 需要在切入点之后执行的逻辑
         */
        LOGGER.info("切点执行之后，开始时间："+System.currentTimeMillis());
    }


    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();//切入点目标方法执行

        long endTime = System.currentTimeMillis();

        Daolog daolog = new Daolog();
        daolog.setStartTime(startTime);
        daolog.setSpendTime((int)(endTime-startTime));
        LOGGER.info("{}", JSONUtil.parse(daolog));

        return result;

    }

}

package com.lzy.webshiro.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class  );

    /**
     * 未授权访问的全局处理
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Object handleAuthorizationException(UnauthorizedException e){
        log.error(e.getMessage(),e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unauth");
        return modelAndView;
    }


}

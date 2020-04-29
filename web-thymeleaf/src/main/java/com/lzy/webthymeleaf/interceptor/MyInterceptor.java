package com.lzy.webthymeleaf.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    //preHandle在业务处理器处理请求之前被调用，true-放行，false-拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截controller之前");
        //request.getRequestDispatcher("/thymeleaf/index").forward(request, response);//转发到"/thymeleaf/index"
        return true;
    }

    //postHandle在业务处理器处理请求执行完成后,生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ModelMap modelMap = modelAndView.getModelMap();
        modelMap.addAttribute("title","lizhiyu");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

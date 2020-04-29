package com.lzy.springboot.interceptor;

import com.lzy.springboot.Utils.CookieUtil;
import com.lzy.springboot.Utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    protected static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1、从cookie中取token
        String token = CookieUtil.getCookieValue(request, "Login-Token");
        //2、判断token是否有值，若有值再用Token去Redis缓存中取值（Redis缓存中的token可以设置过期时间），能取到表示token还在有效期内放行
        if (token==null){
            String msg="Unlogin";
            response.sendRedirect("/loginerror/"+msg);
            logger.info("账号未登录");
            return false;
        }
        if (redisUtil.get(token)==null){
            String msg="Tokenexpire";
            response.sendRedirect("/loginerror/"+msg);
            logger.info("Token过期");
            return false;
        }
        //3、判断通过则放行，否则重定向到登录页
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

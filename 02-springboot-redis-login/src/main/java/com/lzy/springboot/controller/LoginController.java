package com.lzy.springboot.controller;

import com.lzy.springboot.Utils.CookieUtil;
import com.lzy.springboot.Utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
public class LoginController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response,String username, String password){
        if ("lzy".equals(username) && "123".equals(password)){
            //1.生成Token
            String token = UUID.randomUUID().toString();
            //2.将Token保存到Redis缓存中
            redisUtil.set(token,username,1L);

            //3.将Token保存的Cookie中
            CookieUtil.setCookie(request,response,"Login-Token",token);
            return "登录成功";
        }
        return "登录失败";
    }

    @RequestMapping("/loginerror/{msg}")
    public String loginerror(HttpServletRequest request,@PathVariable String msg){
        return msg;
    }

}

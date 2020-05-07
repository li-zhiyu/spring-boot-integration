package com.lzy.webshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping({"/login"})
    public String login(){
        return "login";
    }

    @GetMapping({"/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/unauth")
    public String unauthorizedRole(){
        return "unauth";
    }

    @GetMapping("/delete")
    @RequiresPermissions("delete")
    public String delete(){
        return "delete";
    }

    @GetMapping("/select")
    @RequiresPermissions("select")
    public String select(){
        return "select";
    }

    @PostMapping("/login")
    public void submit(String username, String password, ModelMap map) {
        UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            if (!subject.isAuthenticated()){
                subject.login(upToken);
                map.addAttribute("msg","登录成功");
            }
        }catch (UnknownAccountException e){
            map.addAttribute("msg","用户不存在");
        }catch (IncorrectCredentialsException e){
            map.addAttribute("msg","密码错误");
        }
    }



    @RequestMapping("/login1")
    public String login1(HttpServletRequest request, Map<String, Object> map) throws Exception{
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        //根据异常判断错误类型
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码不正确";
            } else {
                msg = "else >> "+exception;
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "login";
    }


}

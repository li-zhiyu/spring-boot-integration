package com.lzy.webthymeleaf.controller;

import com.lzy.webthymeleaf.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @Autowired
    Environment environment;

    @GetMapping("index")
    public String index(ModelMap modelMap){
        User user = new User();
        user.setName("zhangsan");
        user.setAge("18");
        modelMap.put("msg","集成Thymeleaf成功");
        modelMap.put("user",user);
        modelMap.put("curDate",new Date());
        System.out.println(environment);
        return "index";

    }
}

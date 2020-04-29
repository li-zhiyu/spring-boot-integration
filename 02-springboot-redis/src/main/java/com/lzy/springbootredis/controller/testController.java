package com.lzy.springbootredis.controller;

import com.lzy.springbootredis.entity.User;
import com.lzy.springbootredis.service.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Autowired
    private Service1 service1;

    @RequestMapping("/user")
    @Cacheable(value = "UserInfoListAnother")
    public User getUser(){
        User user = new User();
        user.setUserName("lizhiyu");
        user.setAge(31);
        System.out.println("没有出现这里表示走的缓存");
        return user;

    }

    @RequestMapping("/test")
    public int test(){
        int i = service1.func1();
        int func2 = service1.func2(i);
        return func2;
    }
}

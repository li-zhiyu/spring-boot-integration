package com.lzy.springbootredis.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class Service1 {

    //整体是先查询，再更新

    @Cacheable(cacheNames = "test",key = "'keyname'")
    public int func1(){
        //执行数据库查询
        return 100;
    }

    @CachePut(cacheNames = "test" ,key="'keyname'")
    public int func2(int i){
        //若果func1的结果为null，就往数据库插入一条记录，若不为null,则执行更新操作
        return i+1;
    }
}

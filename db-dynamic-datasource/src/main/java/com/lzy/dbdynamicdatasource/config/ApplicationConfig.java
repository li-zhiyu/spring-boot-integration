package com.lzy.dbdynamicdatasource.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@MapperScan(basePackages = "com.lzy.dbdynamicdatasource.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
public class ApplicationConfig {
}

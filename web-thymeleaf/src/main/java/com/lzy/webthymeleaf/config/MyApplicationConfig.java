package com.lzy.webthymeleaf.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lzy.webthymeleaf.dao")
public class MyApplicationConfig {
}

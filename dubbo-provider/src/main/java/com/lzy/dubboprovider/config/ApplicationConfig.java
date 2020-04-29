package com.lzy.dubboprovider.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lzy.dubboprovider.dao")
public class ApplicationConfig {
}

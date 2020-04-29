package com.lzy.dbdruid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.lzy.dbdruid.dao")
public class DbDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbDruidApplication.class, args);
    }

}

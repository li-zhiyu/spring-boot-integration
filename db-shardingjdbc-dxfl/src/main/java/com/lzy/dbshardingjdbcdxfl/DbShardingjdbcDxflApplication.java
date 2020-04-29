package com.lzy.dbshardingjdbcdxfl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = "com.lzy.dbshardingjdbcdxfl.dao")
public class DbShardingjdbcDxflApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbShardingjdbcDxflApplication.class, args);
    }

}

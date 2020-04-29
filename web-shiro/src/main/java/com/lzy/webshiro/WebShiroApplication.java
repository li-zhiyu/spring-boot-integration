package com.lzy.webshiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebShiroApplication.class, args);
    }

}

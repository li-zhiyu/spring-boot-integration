package com.lzy.webmvc;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@ServletComponentScan(basePackages = "com.lzy.webmvc.servlet")
public class WebMvcApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WebMvcApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);//关闭打印Banner
        ConfigurableApplicationContext run = springApplication.run(args);
        //SpringApplication.run(WebMvcApplication.class, args);//默认启动方式
    }

}

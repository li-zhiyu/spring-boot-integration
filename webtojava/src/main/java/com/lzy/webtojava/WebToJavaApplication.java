package com.lzy.webtojava;

import com.lzy.webtojava.Bean.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot作为非Web项目运行：
 * 方式一：SpringApplication.run（）返回启动的Spring容器，再通过容器获取里面的Bean，执行其他业务逻辑
 * 方式二：用启动类继承CommandLineRunner接口，再在实现方法run()中写业务逻辑
 */
@SpringBootApplication
public class WebToJavaApplication  implements CommandLineRunner {

    @Autowired
    UserService userService;



    public static void main(String[] args) {
        SpringApplication.run(WebToJavaApplication.class, args);//如果没有引入Web启动，则为普通Java程序，执行这条语句应用就结束了！！
        /*
        //方式一
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebToJavaApplication.class, args);
        UserService userService = ((UserService) applicationContext.getBean("userService"));
        System.out.println(userService.getName());
        //这里写业务逻辑。。。。
        */
    }

    //方式二
    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService.getName());
        /**
         * 这里写业务逻辑。。。。
         */
    }
}

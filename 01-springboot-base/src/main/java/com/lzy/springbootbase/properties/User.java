package com.lzy.springbootbase.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = "classpath:myconfig.properties")
@Component
@Data
@ConfigurationProperties(prefix = "user")
@ImportResource()
public class User {
    //@Value("${user.username}")
    private String userName;
    //@Value("${user.age}")
    private Integer age;
    //@Value("${user.id}")
    private String id;

    public User() {
        System.out.println("User注入容器");
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}

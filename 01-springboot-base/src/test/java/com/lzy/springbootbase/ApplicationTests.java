package com.lzy.springbootbase;

import com.lzy.springbootbase.properties.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private User user;

    @Autowired
    private AnnotationConfigApplicationContext ioc;

    private static final Logger log = LoggerFactory.getLogger(ApplicationTests.class);

    @Test
    void contextLoads() {
        System.out.println(user);
        System.out.println(ioc.containsBean("user"));
        Assert.isTrue(ioc.containsBean("user"));
    }

}

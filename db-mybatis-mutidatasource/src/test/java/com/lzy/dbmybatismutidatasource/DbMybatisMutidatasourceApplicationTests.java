package com.lzy.dbmybatismutidatasource;

import com.lzy.dbmybatismutidatasource.entity.Orders;
import com.lzy.dbmybatismutidatasource.entity.Users;
import com.lzy.dbmybatismutidatasource.service.OrdersService;
import com.lzy.dbmybatismutidatasource.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DbMybatisMutidatasourceApplicationTests {

    @Autowired
    private UsersService usersService;

    @Autowired
    private OrdersService ordersService;

    @Test

    @Transactional(transactionManager = "userTansactionManager")
    void contextLoads() {
        method1();
        method2();
    }


    void method1(){
        Users users = usersService.queryById(5);
        System.out.println(users);
    }

    @Transactional(transactionManager = "orderTansactionManager")
    void method2(){
        Orders orders = ordersService.queryById(10021);
        System.out.println(orders);
    }

}

package com.lzy.dbdynamicdatasource;

import com.lzy.dbdynamicdatasource.entity.Orders;
import com.lzy.dbdynamicdatasource.service.OrdersService;
import com.lzy.dbdynamicdatasource.service.SysUserService;
import com.lzy.dbdynamicdatasource.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DbDynamicDatasourceApplicationTests {
    @Autowired
    private UsersService usersService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private OrdersService ordersService;

    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            Orders orders = ordersService.queryById(10022);
            System.out.println(orders);
        }


        Orders orders1 = new Orders();
        orders1.setUserId(1897632);
        ordersService.insert(orders1);


    }

}

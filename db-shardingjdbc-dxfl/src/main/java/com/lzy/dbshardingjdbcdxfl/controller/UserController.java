package com.lzy.dbshardingjdbcdxfl.controller;

import com.lzy.dbshardingjdbcdxfl.entity.User;
import com.lzy.dbshardingjdbcdxfl.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-10 09:21:33
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    @GetMapping("selectAll")
    public List<User> selectAll() {
        return this.userService.queryAllByLimit(0,10);
    }

    @GetMapping("save")
    public void save(){
        User user = new User();
        user.setId(100L);
        user.setName("dalaoyang");
        user.setCity("beijing");
        userService.insert(user);
    }

}
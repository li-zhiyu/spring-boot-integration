package com.lzy.dbdruid.controller;

import com.lzy.dbdruid.entity.SysUser;
import com.lzy.dbdruid.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户信息表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-03-16 15:15:14
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUser selectOne(Long id) {
        return this.sysUserService.queryById(id);
    }

}
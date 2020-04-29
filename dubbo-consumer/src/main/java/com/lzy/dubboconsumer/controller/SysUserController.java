package com.lzy.dubboconsumer.controller;

import com.lzy.dubbofacade.entity.SysUser;
import com.lzy.dubbofacade.service.SysUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-03-02 16:19:58
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Reference(version = "1.0.0")
    private SysUserService sysUserService;

    private static Logger logger=LoggerFactory.getLogger(SysUserController.class);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUser selectOne(Integer id) {
        logger.info("测试logger使用");
        return this.sysUserService.queryById(id);
    }

}
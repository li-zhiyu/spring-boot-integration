package com.lzy.webthymeleaf.controller;

import com.github.pagehelper.PageHelper;
import com.lzy.webthymeleaf.aop.SysLog;
import com.lzy.webthymeleaf.entity.SysUser;
import com.lzy.webthymeleaf.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-03-16 17:16:55
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;


    @GetMapping("userList")
    @SysLog("userList访问")
    public String userList(@RequestParam("pageNum") String pageNum,
                           @RequestParam("pageSize") String pageSize,
                           ModelMap modelMap){
        PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
        List<SysUser> sysUsers = sysUserService.queryAll();
        modelMap.put("userlist",sysUsers);
        return "User";
    }

}
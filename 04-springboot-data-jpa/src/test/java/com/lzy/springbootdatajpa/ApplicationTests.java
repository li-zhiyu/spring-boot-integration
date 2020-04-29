package com.lzy.springbootdatajpa;

import com.lzy.springbootdatajpa.entity.SysUser;
import com.lzy.springbootdatajpa.repository.MenuRepository;
import com.lzy.springbootdatajpa.repository.RoleRepository;
import com.lzy.springbootdatajpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MenuRepository menuRepository;

    @Test
    void contextLoads() {
        SysUser user = userRepository.findByUserNameContains("ka");
        System.out.println(user);

        PageRequest ddd = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "ddd"));
        List<SysUser> lusi = userRepository.getSysUserByUsername("l%");
        lusi.stream().forEach(sysUser -> {
            System.out.println(sysUser.getUserName());
        });

    }

}

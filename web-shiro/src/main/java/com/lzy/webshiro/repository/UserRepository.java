package com.lzy.webshiro.repository;

import com.lzy.webshiro.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUserName(String username);

}

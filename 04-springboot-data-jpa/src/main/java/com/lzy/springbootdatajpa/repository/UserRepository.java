package com.lzy.springbootdatajpa.repository;

import com.lzy.springbootdatajpa.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<SysUser,Integer> {
    SysUser findByUserNameContains(String str);

    @Query("select s from SysUser  s  where s.userName like ?1 ")
    List<SysUser> getSysUserByUsername(String str);
}

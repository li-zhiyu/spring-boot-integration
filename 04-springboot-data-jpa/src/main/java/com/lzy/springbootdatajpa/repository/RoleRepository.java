package com.lzy.springbootdatajpa.repository;

import com.lzy.springbootdatajpa.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<SysRole,Integer> {
}

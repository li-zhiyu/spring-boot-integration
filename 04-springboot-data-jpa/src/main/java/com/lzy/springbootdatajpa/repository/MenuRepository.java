package com.lzy.springbootdatajpa.repository;

import com.lzy.springbootdatajpa.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<SysMenu,Integer> {
}

package com.lzy.springbootdatajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;

    //多对多关系
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRoleMenu",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="menuId")})
    private List<SysMenu> menuList;

    //多对多关系
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
    private List<SysUser> userList;// 一个角色对应多个用户

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}

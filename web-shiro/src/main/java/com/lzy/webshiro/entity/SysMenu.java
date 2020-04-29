package com.lzy.webshiro.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SysMenu {
    @Id
    @GeneratedValue
    private Integer menuId;
    private String menuName;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRoleMenu",joinColumns={@JoinColumn(name="menuId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roleList;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}

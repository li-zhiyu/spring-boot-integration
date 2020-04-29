package com.lzy.springbootdatajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class SysMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;
    private String menuName;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRoleMenu",joinColumns={@JoinColumn(name="menuId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roleList;

    @Override
    public String toString() {
        return "SysMenu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}

package com.lzy.springbootdatajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class SysUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String passWord;

    //多对多关系
    @OneToMany(fetch= FetchType.EAGER)
    //急加载，加载一个实体时，定义急加载的属性会立即从数据库中加载
    //FetchType.LAZY：懒加载，加载一个实体时，定义懒加载的属性不会马上从数据库中加载
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}

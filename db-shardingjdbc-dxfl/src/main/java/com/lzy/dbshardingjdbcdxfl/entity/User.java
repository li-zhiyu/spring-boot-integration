package com.lzy.dbshardingjdbcdxfl.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-10 09:21:33
 */
public class User implements Serializable {
    private static final long serialVersionUID = 778066112383170078L;
    
    private Long id;
    
    private String city;
    
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
package com.lzy.dbmybatismutidatasource.entity;

import java.io.Serializable;

/**
 * 订单表(Orders)实体类
 *
 * @author makejava
 * @since 2020-04-08 14:15:47
 */
public class Orders implements Serializable {
    private static final long serialVersionUID = -28069454096413838L;
    /**
     * 订单编号
     */
    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                '}';
    }
}
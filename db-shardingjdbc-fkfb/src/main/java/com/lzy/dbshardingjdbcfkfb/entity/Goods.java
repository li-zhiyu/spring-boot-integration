package com.lzy.dbshardingjdbcfkfb.entity;

import java.io.Serializable;

/**
 * (Goods0)实体类
 *
 * @author makejava
 * @since 2020-04-09 15:54:09
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = -45743434481656911L;
    
    private Long goodsId;
    
    private String goodsName;
    
    private Long goodsType;


    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Long goodsType) {
        this.goodsType = goodsType;
    }

}
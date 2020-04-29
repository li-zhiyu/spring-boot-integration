package com.lzy.dbshardingjdbcfkfb.controller;

import com.lzy.dbshardingjdbcfkfb.entity.Goods;
import com.lzy.dbshardingjdbcfkfb.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goods0)表控制层
 *
 * @author makejava
 * @since 2020-04-09 15:54:09
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Goods selectOne(Long id) {
        return this.goodsService.queryById(id);
    }

    @GetMapping("save")
    public String save(){
        for(int i= 1 ; i <= 40 ; i ++){
            Goods goods = new Goods();
            goods.setGoodsId((long) i);
            goods.setGoodsName( "shangpin" + i);
            goods.setGoodsType((long) (i+1));
            goodsService.insert(goods);
        }
        return "success";
    }

    @GetMapping("query")
    public List<Goods> query(){
        List<Goods> goods = goodsService.queryAllByLimit(10, 10);
        return goods;
    }

    @GetMapping("querAll")
    public List<Goods> queryone(){
        List<Goods> goods = goodsService.queryAll(null);
        return goods;
    }


}
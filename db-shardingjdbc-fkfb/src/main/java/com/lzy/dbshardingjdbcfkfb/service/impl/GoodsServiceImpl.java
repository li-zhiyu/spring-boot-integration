package com.lzy.dbshardingjdbcfkfb.service.impl;

import com.lzy.dbshardingjdbcfkfb.entity.Goods;
import com.lzy.dbshardingjdbcfkfb.dao.GoodsDao;
import com.lzy.dbshardingjdbcfkfb.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goods0)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 15:54:09
 */
@Service("goods0Service")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goods0Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Long goodsId) {
        return this.goods0Dao.queryById(goodsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Goods> queryAllByLimit(int offset, int limit) {
        return this.goods0Dao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        this.goods0Dao.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        this.goods0Dao.update(goods);
        return this.queryById(goods.getGoodsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long goodsId) {
        return this.goods0Dao.deleteById(goodsId) > 0;
    }

    @Override
    public List<Goods> queryAll(Goods goods) {
        return goods0Dao.queryAll(goods);
    }
}
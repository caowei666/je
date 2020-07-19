package com.caowei.service.impl;

import com.caowei.dao.GoodsDao;
import com.caowei.dao.impl.GoodsDaoImpl;
import com.caowei.domain.Goods;
import com.caowei.domain.PageBean;
import com.caowei.service.GoodsServie;

import java.util.List;

public class GoodsServiceImpl implements GoodsServie {
    GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public PageBean<Goods> findByWhere(int pageN, int pageS, String condition) {
        long totalSize = goodsDao.getCount(condition);
        //获取当前页数据
        List<Goods> data = goodsDao.findByWhere(pageN, pageS, condition);
        PageBean<Goods> pageBean = new PageBean<>(pageN,pageS,totalSize,data);
        return pageBean;
    }
}

package com.caowei.service.impl;

import com.caowei.dao.GoodsTypeDao;
import com.caowei.dao.impl.GoodsTypeDaoImpl;
import com.caowei.domain.GoodsType;
import com.caowei.service.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
    @Override
    public List<GoodsType> getGoodsTypeByLevel(int level) {
       return goodsTypeDao.findByLevel(level);
    }
}

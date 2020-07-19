package com.caowei.dao;

import com.caowei.domain.Goods;

import java.util.List;

public interface GoodsDao {
    long getCount(String condition);
    List<Goods> findByWhere(int pageN,int pageS,String condition);
}

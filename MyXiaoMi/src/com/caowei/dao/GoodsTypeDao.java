package com.caowei.dao;

import com.caowei.domain.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    List<GoodsType> findByLevel(int level);
}

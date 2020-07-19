package com.caowei.service;

import com.caowei.domain.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsType> getGoodsTypeByLevel(int level);
}

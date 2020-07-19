package com.caowei.service;

import com.caowei.domain.Goods;
import com.caowei.domain.PageBean;

public interface GoodsServie {
    PageBean<Goods> findByWhere(int pageN, int pageS, String condition);
}

package com.test.ssm.service;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.Bill;

import java.util.List;

public interface BillService {
    int insert(Bill bill);

    int update(Bill bill);

    Bill getBillById(Integer id);

    PageInfo<Bill> getBillList(Bill bill,Integer pageNum,Integer pageSize);

    void deleteById(Integer id);
}

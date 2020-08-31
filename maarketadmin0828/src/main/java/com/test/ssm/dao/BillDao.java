package com.test.ssm.dao;

import com.test.ssm.pojo.Bill;

import java.util.List;

public interface BillDao {
    int insert(Bill bill);

    int update(Bill bill);

    Bill getBillById(Integer id);

    List<Bill> getBillList(Bill bill);

    void deleteById(Integer id);
}

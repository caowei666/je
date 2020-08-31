package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.ssm.dao.BillDao;
import com.test.ssm.pojo.Bill;
import com.test.ssm.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
    @Autowired(required = false)
    private BillDao billDao;
    @Override
    public int insert(Bill bill) {
        return billDao.insert(bill);
    }

    @Override
    public int update(Bill bill) {
        return billDao.update(bill);
    }

    @Override
    public Bill getBillById(Integer id) {
        return billDao.getBillById(id);
    }

    @Override
    public PageInfo<Bill> getBillList(Bill bill, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(billDao.getBillList(bill));
    }

    @Override
    public void deleteById(Integer id) {
        billDao.deleteById(id);
    }
}

package com.test.boot.service.Impl;

import com.test.boot.dao.DeptDAO;
import com.test.boot.pojo.Dept;
import com.test.boot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptDAO deptDAO;

    @Override
    public List<Dept> getDeptList() {
        return deptDAO.getDeptList();
    }

    @Override
    public void addDept(Dept dept) {
        deptDAO.addDept(dept);
    }
}

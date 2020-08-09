package com.test.service;

import com.test.dao.DeptDAO;
import com.test.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //生命为一个service
public class DeptService {
    @Autowired
    private DeptDAO deptDAO;   //由于实现类和session都是spring提供的，所有此处必须由spring提供
    //deptDao,自己new的不能用，spring会给生成代理对象
   public void add(Dept dept){
        deptDAO.addDept(dept);
        deptDAO.addDept(dept);
    }
}

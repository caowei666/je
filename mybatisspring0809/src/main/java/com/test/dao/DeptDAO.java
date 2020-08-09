package com.test.dao;

import com.test.pojo.Dept;

public interface DeptDAO {
    Dept getDeptById(Integer id);
    int addDept(Dept dept);
}

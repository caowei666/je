package com.test.boot.service;

import com.test.boot.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> getDeptList();

    void addDept(Dept dept);
}

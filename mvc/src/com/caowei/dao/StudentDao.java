package com.caowei.dao;

import com.caowei.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findByPage(Integer pageNum,Integer pageSize);
    long getCount();
    void add(Student student);
}

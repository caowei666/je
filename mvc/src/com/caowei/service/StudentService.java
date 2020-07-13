package com.caowei.service;

import com.caowei.domain.PageBean;
import com.caowei.domain.Student;

public interface StudentService {
    PageBean<Student> findByPage(Integer pageNum, Integer pageSize);
}

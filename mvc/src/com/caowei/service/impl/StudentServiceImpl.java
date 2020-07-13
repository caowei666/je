package com.caowei.service.impl;

import com.caowei.dao.StudentDao;
import com.caowei.dao.impl.StudentDaoImpl;
import com.caowei.domain.PageBean;
import com.caowei.domain.Student;
import com.caowei.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public PageBean<Student> findByPage(Integer pageNum, Integer pageSize) {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> data = studentDao.findByPage(pageNum, pageSize);
        long totalSize = studentDao.getCount();
        PageBean<Student> pageBean = new PageBean<>(pageNum,pageSize,totalSize,data);
        return pageBean;
    }
}

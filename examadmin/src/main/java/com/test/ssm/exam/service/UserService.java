package com.test.ssm.exam.service;

import com.github.pagehelper.PageInfo;
import com.test.ssm.exam.pojo.User;

import java.util.List;

public interface UserService {
    User doLogin(String account,String password);

    PageInfo<User> getUserList(User user,int pageNum, int pageSize);

    void  addUser(User user);

    void updateUser(User user);
}

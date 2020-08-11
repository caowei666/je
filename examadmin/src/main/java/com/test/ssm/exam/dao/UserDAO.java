package com.test.ssm.exam.dao;

import com.test.ssm.exam.pojo.User;

import java.util.List;

public interface UserDAO {
    User getUserByAccount(String account);

    List<User> getUserList(User user);

    void  addUser(User user);

    void updateUser(User user);
}

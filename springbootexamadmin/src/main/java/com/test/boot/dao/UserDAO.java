package com.test.boot.dao;

import com.test.boot.pojo.User;

import java.util.List;

public interface UserDAO {
    User getUserByAccount(String account);

    List<User> getUserList(User user);

    void  addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}

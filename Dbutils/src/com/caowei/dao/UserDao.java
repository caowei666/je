package com.caowei.dao;

import com.caowei.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findByid(Integer id);
    void add(User user);
    void update(User user);
    void delete(Integer id);
}

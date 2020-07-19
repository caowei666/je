package com.caowei.dao;

import com.caowei.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Integer id);
    User findByUsernameAndPassword(String username,String password);
    User findByUsername(String username);
    void add(User user);
    void update(User user);
    void delete(Integer id);
}

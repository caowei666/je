package com.caowei.Dao;

import com.caowei.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}

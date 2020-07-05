package com.caowei.dao;

import com.caowei.domain.User;

public interface UserDao {
    void add(User user);
    void update(User user);
    void delete(int uid);
}

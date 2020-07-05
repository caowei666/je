package com.caowei.dao.impl;

import com.caowei.dao.UserDao;
import com.caowei.domain.User;
import com.caowei.utils.DBUtils;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        String sql = "insert into student values(?,?,?,?)";
        Object[] params={user.getId(),user.getUsername(),user.getPassword(),user.getEmail()};
        DBUtils.executeUpdate(sql,params);
        System.out.println("添加成功");
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int uid) {

    }
}

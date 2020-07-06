package com.caowei.dao.impl;

import com.caowei.dao.UserDao;
import com.caowei.domain.User;
import com.caowei.utils.DBUtils;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        String sql = "insert into user values(?,?,?,?)";
        Object[] params={user.getId(),user.getUsername(),user.getPassword(),user.getEmail()};
        DBUtils.executeUpdate(sql,params);
        System.out.println("添加成功");
    }

    @Override
    public void update(User user) {
        String sql = "update user set username=? where id=?";
        Object[] params = {user.getUsername(),user.getId()};
        DBUtils.executeUpdate(sql,params);
        System.out.println("更新成功");
    }

    @Override
    public void delete(int uid) {
        String sql = "delete from user where id=?";
        Object[] params = {uid};
        DBUtils.executeUpdate(sql,params);
        System.out.println("删除成功");
    }
}

package com.caowei.dao.impl;

import com.caowei.dao.UserDao;
import com.caowei.domain.User;
import com.caowei.utils.DataScorceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataScource());
        try {
            return qr.query("select * from tb_user",new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有用户失败");
        }
    }

    @Override
    public User findById(Integer id) {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataScource());
        try {
            return qr.query("select * from tb_user where id = ?",new BeanHandler<>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据id查询用户失败");
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataScource());
        try {
            return qr.query("select * from tb_user where username = ? and password = ?",new BeanHandler<>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查不出来");
            throw new RuntimeException("根据用户名和密码查询所有用户失败");
        }
    }

    @Override
    public User findByUsername(String username) {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataScource());
        try {
            return qr.query("select * from tb_user where username = ?" ,new BeanHandler<>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据用户名查询用户失败");
        }
    }

    @Override
    public void add(User user) {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataScource());
        Object[] params = {user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getFlag(),user.getRole(),user.getCode()};
        try {
            qr.update("insert into tb_user(username,password,email,gender,flag,role,code) values(?,?,?,?,?,?,?)" ,params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加用户失败");
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {

    }
}

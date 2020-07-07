package com.caowei.dao.UserDaoImpl;

import com.caowei.Utils.DataSourceUtils;
import com.caowei.dao.UserDao;
import com.caowei.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = null;
    @Override
    public List<User> findAll() {
        //1、BeanListHandler，返回list集合
        //2、BeanHandler 返回单个对象
        //3、ScalarHandler 返回单个值
        qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from user",new BeanListHandler<>(User.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByid(Integer id) {
        qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from user where id=?",new BeanHandler<>(User.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(User user) {
        qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object[] params = {user.getId(),user.getUsername(),user.getPassword(),user.getEmail()};
        try {
            qr.update("insert into user values(?,?,?,?)",params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object[] params = {user.getUsername(),user.getPassword(),user.getEmail(),user.getId()};
        try {
            qr.update("update user set username=?,password=?,email=? where id=?",params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            qr.update("delete from user where id=?",id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

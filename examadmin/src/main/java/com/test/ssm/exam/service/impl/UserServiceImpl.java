package com.test.ssm.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.ssm.exam.dao.UserDAO;
import com.test.ssm.exam.pojo.User;
import com.test.ssm.exam.service.UserService;
import com.test.ssm.exam.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public User doLogin(String account, String password) {
        User user = userDAO.getUserByAccount(account);
        if(user == null || !user.getPassword().equals(password)){
            return null;    //用户名或密码错误
        }
        return user;
    }

    @Override
    public PageInfo<User> getUserList(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(userDAO.getUserList(user));
    }

    @Override
    public AjaxResult addUser(User user) {
        AjaxResult ajaxResult = new AjaxResult();
        if(userDAO.getUserByAccount(user.getAccount()) == null){
            userDAO.addUser(user);
            ajaxResult.setStatus(true);
            return ajaxResult;
        }else{
            ajaxResult.setMessage("用户名已存在");
            return ajaxResult;
        }
    }

    @Override
    public AjaxResult updateUser(User user) {
        AjaxResult ajaxResult = new AjaxResult();
        try {
            userDAO.updateUser(user);
            ajaxResult.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setStatus(false);
            ajaxResult.setMessage("用户名已存在");
        }
        return ajaxResult;
    }

    //此处不能try() catch() 异常不扔出去事务无法回滚
    @Override
    public AjaxResult deleteUser(int[] ids) {
        AjaxResult ajaxResult = new AjaxResult();
        for(int id:ids){
            userDAO.deleteUser(id);
        }
        ajaxResult.setStatus(true);
        return ajaxResult;
    }
}

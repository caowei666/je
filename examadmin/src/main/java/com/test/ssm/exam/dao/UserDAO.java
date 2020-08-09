package com.test.ssm.exam.dao;

import com.test.ssm.exam.pojo.User;

public interface UserDAO {
    User getUserByAccount(String account);
}

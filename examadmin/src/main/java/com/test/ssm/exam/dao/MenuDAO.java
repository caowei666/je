package com.test.ssm.exam.dao;

import com.test.ssm.exam.pojo.Menu;

import java.util.List;

public interface MenuDAO {
    List<Menu> getAllMenu();
    void addMenu(Menu menu);
    void updateMenu(Menu menu);
    void deleteMenu(int id);
}

package com.test.boot.dao;

import com.test.boot.pojo.Menu;

import java.util.List;

public interface MenuDAO {
    List<Menu> getAllMenu();

    void addMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenu(int id);
}

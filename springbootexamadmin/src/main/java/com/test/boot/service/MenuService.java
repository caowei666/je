package com.test.boot.service;

import com.test.boot.pojo.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuTree(boolean needButton);
    void addMenu(Menu menu);
    void updateMenu(Menu menu);
    void deleteMenu(int[] ids);
    List<Menu> getUserMenuList(Integer userId);
}

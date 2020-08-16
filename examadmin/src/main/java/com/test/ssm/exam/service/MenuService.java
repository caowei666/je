package com.test.ssm.exam.service;

import com.test.ssm.exam.pojo.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuTree(boolean needButton);
    void addMenu(Menu menu);
    void updateMenu(Menu menu);
    void deleteMenu(int[] ids);
}

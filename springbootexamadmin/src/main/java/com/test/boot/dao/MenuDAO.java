package com.test.boot.dao;

import com.test.boot.pojo.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDAO {
    List<Menu> getAllMenu();

    void addMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenu(int id);
}

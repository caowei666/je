package com.test.ssm.exam.service.impl;

import com.test.ssm.exam.dao.MenuDAO;
import com.test.ssm.exam.pojo.Menu;
import com.test.ssm.exam.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;
    @Override
    public List<Menu> getMenuTree() {
        List<Menu> allMenu = menuDAO.getAllMenu();
        List<Menu> firseMenu=new ArrayList<>();
        Map<Integer,Menu> menuMap = new HashMap<>();
        for (Menu m:allMenu){
            if(m.getParentId()==null){
                firseMenu.add(m);
            }
            menuMap.put(m.getId(),m);
        }
        for (Menu m:allMenu){
            if(m.getParentId()!=null &&menuMap.containsKey(m.getParentId())){
                menuMap.get(m.getParentId()).getChildren().add(m);
            }
        }
        return firseMenu;
    }
}

package com.test.ssm.exam.service.impl;

import com.test.ssm.exam.dao.MenuDAO;
import com.test.ssm.exam.dao.PremissionDAO;
import com.test.ssm.exam.pojo.Menu;
import com.test.ssm.exam.service.MenuService;
import com.test.ssm.exam.util.AjaxResult;
import com.test.ssm.exam.util.ExamConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;

    @Autowired
    private PremissionDAO premissionDAO;

    @Override
    public List<Menu> getMenuTree(boolean needButton) {
        List<Menu> allMenu = menuDAO.getAllMenu();
        return makeMenuTree(needButton,allMenu);
    }

    public List<Menu> makeMenuTree(boolean needButton, List<Menu> allMenu){
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
                System.out.println(m);
                if(!needButton && m.getType().equals(ExamConstants.MENU_TYPE_BUTTON)){
                    continue;
                }
                menuMap.get(m.getParentId()).getChildren().add(m);
            }
        }
        return firseMenu;
    }

    @Override
    public void addMenu(Menu menu) {
        menuDAO.addMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuDAO.updateMenu(menu);
    }

    @Override
    public void deleteMenu(int[] ids) {
        for (int id:ids){
            menuDAO.deleteMenu(id);
        }
    }

    @Override
    public List<Menu> getUserMenuList(Integer userId) {
        return makeMenuTree(false,premissionDAO.getUserMenuList(userId));
    }
}

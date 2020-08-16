package com.test.ssm.exam.controller;

import com.test.ssm.exam.pojo.Menu;
import com.test.ssm.exam.service.MenuService;
import com.test.ssm.exam.util.AjaxResult;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/menu.html")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping
    public String menu(){
        return "menu";
    }

    @RequestMapping(params = "act=tree")
    @ResponseBody
    public List<Menu> tree(boolean needButton){
        return menuService.getMenuTree(needButton);
    }

    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxResult edit(Menu menu){
        AjaxResult res = new AjaxResult();
        try {
            if(menu.getId()==null){
                menuService.addMenu(menu);
            }else{
                menuService.updateMenu(menu);
            }
            res.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @RequestMapping(params = "act=delete")
    @ResponseBody
    public AjaxResult delete(int[] ids){
        AjaxResult res = new AjaxResult();
        try {
            menuService.deleteMenu(ids);
            res.setStatus(true);
        } catch (Exception e) {
           e.printStackTrace();
            res.setStatus(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }
}

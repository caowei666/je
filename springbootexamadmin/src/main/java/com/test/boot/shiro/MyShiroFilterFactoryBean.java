package com.test.boot.shiro;

import com.test.boot.dao.MenuDAO;
import com.test.boot.dao.PremissionDAO;
import com.test.boot.pojo.Menu;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {
    private PremissionDAO premissionDAO;
    private MenuDAO menuDAO;
    @Override
    public void setFilterChainDefinitions(String definitions) {
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection("urls");
        if (CollectionUtils.isEmpty((Collection) section)) {
            section = ini.getSection("");
        }
        List<Menu> menus = menuDAO.getAllMenu();
        for (Menu menu : menus) {
            if(!StringUtils.isEmpty(menu.getUrl())){
                List<String> roleIds = premissionDAO.getRoleIdsByMenuId(menu.getId());
                if(roleIds!=null&&roleIds.size()>0){
                    section.put(menu.getUrl(),"roles"+roleIds);
                }
            }
        }
        //section.put("/menu/**","roles[admin]");
        this.setFilterChainDefinitionMap(section);
    }

    public void setPremissionDAO(PremissionDAO premissionDAO) {
        this.premissionDAO = premissionDAO;
    }

    public void setMenuDAO(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
}

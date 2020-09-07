package com.test.boot;

import com.test.boot.dao.MenuDAO;
import com.test.boot.dao.PremissionDAO;
import com.test.boot.shiro.MyRealml;
import com.test.boot.shiro.MyShiroFilterFactoryBean;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Bean
    public DefaultWebSecurityManager securityManager(MyRealml realml){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realml);
        return securityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager, PremissionDAO premissionDAO, MenuDAO menuDAO){
        MyShiroFilterFactoryBean shiroFilterFactoryBean = new MyShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("error.html");
        shiroFilterFactoryBean.setPremissionDAO(premissionDAO);
        shiroFilterFactoryBean.setMenuDAO(menuDAO);
        shiroFilterFactoryBean.setFilterChainDefinitions(
                "                /login.html=anon\n" +
                "                /error.html=anon\n" +
                "                /dologin.html=anon\n");
        return shiroFilterFactoryBean;
    }
}

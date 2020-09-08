package com.test.boot;

import com.test.boot.dao.MenuDAO;
import com.test.boot.dao.PremissionDAO;
import com.test.boot.shiro.MyRealml;
import com.test.boot.shiro.MyRoleFilter;
import com.test.boot.shiro.MyShiroFilterFactoryBean;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public DefaultWebSecurityManager securityManager(MyRealml realml){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realml);
        securityManager.setCacheManager(cacheManager());  //开启缓存
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
                "                /index.html=authc\n" +
                "                /dologin.html=anon\n");
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("roles",new MyRoleFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        return shiroFilterFactoryBean;
    }
    //启用缓存的bean
    @Bean
    public MemoryConstrainedCacheManager cacheManager(){
        return new MemoryConstrainedCacheManager();
    }
    //启用注解的bean
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return  advisor;
    }
}

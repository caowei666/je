package com.test.boot.shiro;

import com.test.boot.dao.PremissionDAO;
import com.test.boot.dao.UserDAO;
import com.test.boot.pojo.Menu;
import com.test.boot.pojo.User;
import com.test.boot.util.ExamConstants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;

//定义数据源
@Component
public class MyRealml extends AuthorizingRealm {
    @Autowired(required = false)
    private UserDAO userDAO;

    @Autowired
    private PremissionDAO premissionDAO;
    //用于授权，在此告诉shiro当前用户有哪些权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("每次访问菜单再次进行权限验证");
        Subject subject = SecurityUtils.getSubject();
        List<Integer> roleIds = premissionDAO.getUserRoleByUserId((int)subject.getPrincipal());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(roleIds!=null){
            for (Integer roleId:roleIds){
                info.addRole(roleId.toString());
            }
        }
        List<Menu> userMenu = premissionDAO.getUserMenuList((int)subject.getPrincipal());
        //拥有了细粒度的权限
        if(userMenu!=null){
            for (Menu menu : userMenu) {
                if(!StringUtils.isEmpty(menu)){
                    info.addStringPermission(menu.getPerms());
                }
            }
        }
        return info;
    }

    //用于登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userDAO.getUserByAccount(token.getUsername());
        if(user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user.getId(),user.getPassword(),getName());
    }
}

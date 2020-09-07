package com.test.boot.shiro;

import com.test.boot.dao.UserDAO;
import com.test.boot.pojo.User;
import com.test.boot.util.ExamConstants;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

//定义数据源
@Component
public class MyRealml extends AuthorizingRealm {
    @Autowired(required = false)
    private UserDAO userDAO;
    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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

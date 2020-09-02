package com.test.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

//public class MyRealm implements Realm {
public class MyRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return "MyRealm";  //给realm起名
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //判断用户是否以用户名密码登录
        return authenticationToken instanceof UsernamePasswordToken;
    }

//    @Override
//    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        //用户登录成功shiro会返回AuthenticationInfo给用户
//        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//        System.out.println(token.getUsername());
//        //根据用户名查询数据库，找到用户真正的密码
//        if("admin".equals(token.getUsername()) && "123456".equals(token.getPassword())){
//            return new SimpleAuthenticationInfo("admin","123456",getName());
//        }else if (!"admin".equals(token.getUsername())){
//            throw new UnknownAccountException();
//        }else{
//            throw new IncorrectCredentialsException();
//        }
//        //System.out.println(token.getPassword());
//        //return new SimpleAuthenticationInfo("唯一标志","真实密码","数据源");
//    }

    //用来授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("获取用户主键："+principalCollection.getPrimaryPrincipal());
        //根据主键查询用户权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("admin");
        authorizationInfo.addStringPermission("index.html");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //用户登录成功shiro会返回AuthenticationInfo给用户
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        System.out.println("token:"+token.getUsername());
        //根据用户名查询数据库，找到用户真正的密码
//        if("admin".equals(token.getUsername()) && "123456".equals(token.getPassword())){
//            return new SimpleAuthenticationInfo("admin","123456",getName());
//        }else if (!"admin".equals(token.getUsername())){
//            throw new UnknownAccountException();
//        }else{
//            throw new IncorrectCredentialsException();
//        }
        if("admin".equals(token.getUsername())){
            return new SimpleAuthenticationInfo("admin","123456",getName());
        }else{
            throw new UnknownAccountException();
        }
        //System.out.println(token.getPassword());
        //return new SimpleAuthenticationInfo("唯一标志","真实密码","数据源");
    }
}

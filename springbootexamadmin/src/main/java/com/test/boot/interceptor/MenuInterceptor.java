package com.test.boot.interceptor;

import com.test.boot.pojo.Menu;
import com.test.boot.util.ExamConstants;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MenuInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Menuinterceptor:"+request.getServletPath());
        List<Menu> menus = (List<Menu>)request.getSession().getAttribute(ExamConstants.USER_MENU);
        if(check(menus,request.getServletPath())){
            return true;
        }
        response.sendRedirect("/error.html");
        return false;
    }

    public boolean check(List<Menu> menus,String path){
        for(Menu menu:menus){
            if(!StringUtils.isEmpty(menu.getUrl()) && menu.getUrl().contains(path)){
                return true;
            }
            if(menu.getChildren().size()>0){
                boolean check = check(menu.getChildren(), path);
                if(check) return check;
            }
        }
        return false;
    }
}

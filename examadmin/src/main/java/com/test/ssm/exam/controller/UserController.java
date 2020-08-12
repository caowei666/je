package com.test.ssm.exam.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.exam.util.AjaxResult;
import com.test.ssm.exam.util.TableData;
import com.test.ssm.exam.pojo.User;
import com.test.ssm.exam.service.UserService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys/user.html")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping
    public String page(){
        return "user";
    }
    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(User user,Integer page,Integer limit){
        PageInfo<User> pageInfo = userService.getUserList(user,page,limit);
        return new TableData(pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxResult edit(User user){
       if(user.getId()==null){
           return userService.addUser(user);
       }
       return userService.updateUser(user);
    }

    @RequestMapping(params = "act=delete")
    @ResponseBody
    public AjaxResult delete(int[] ids){
        try {
            return userService.deleteUser(ids);
        } catch (Exception e) {
            e.printStackTrace();
            AjaxResult ajaxResult = new AjaxResult();
            ajaxResult.setStatus(false);
            ajaxResult.setMessage(e.getMessage());
            return ajaxResult;
        }
    }
}

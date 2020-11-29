package com.smu.edu.controller;

import com.smu.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(tags="登录管理")
@RequestMapping("/edu/user")
public class LoginController {
    @PostMapping("/login")
    public Result login(){
        return Result.success().data("token","admin");
    }

    @GetMapping("/info")
    public Result info(){
        return Result.success().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}

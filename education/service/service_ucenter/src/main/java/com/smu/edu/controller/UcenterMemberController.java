package com.smu.edu.controller;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smu.edu.domain.UcenterMember;
import com.smu.edu.service.UcenterMemberService;
import com.smu.edu.vo.RegisterParams;
import com.smu.utils.JwtUtils;
import com.smu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caowei
 * @since 2020-12-05
 */
@RestController
@RequestMapping("/ucenter/member")
@CrossOrigin
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService memberService;

    @PostMapping("/login")
    public Result login(@RequestBody UcenterMember ucenterMember){
        String token = memberService.login(ucenterMember);
        return Result.success().data("token",token);
    }

    @PostMapping("/register")
    public Result register(@RequestBody RegisterParams registerParams){
        memberService.register(registerParams);
        return Result.success();
    }

    @GetMapping("/getMemberInfo")
    public Result getMemberInfo(HttpServletRequest request){
        String memberIdByJwtToken = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember byId = memberService.getById(memberIdByJwtToken);
        return Result.success().data("member",byId);
    }

    @GetMapping("/getMemberInfo/{id}")
    public Result getMenberInfo(@PathVariable String id){
        UcenterMember byId = memberService.getById(id);
        return Result.success().data("member",byId);
    }
}


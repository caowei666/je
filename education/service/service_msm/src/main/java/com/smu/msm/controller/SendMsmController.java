package com.smu.msm.controller;

import com.smu.msm.service.MsmService;
import com.smu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msm/msm")
@CrossOrigin
public class SendMsmController {
    @Autowired
    private MsmService msmService;

    @GetMapping("send/{phone}")
    public Result send(@PathVariable String phone){
        boolean isSend = msmService.send(phone);
        if(isSend) {
            return Result.success();
        }else {
            return Result.error();
        }
    }
}

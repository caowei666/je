package com.smu.oss.controller;


import com.smu.oss.service.VodService;
import com.smu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vod/video")
public class VodController {
    @Autowired
    private VodService vodService;

    @PostMapping("/uploadAliyunVideo")
    public Result uploadAliyunVideo(MultipartFile file){
        String videoId = vodService.uploadAliyunVideo(file);
        return Result.success().data("videoId",videoId);
    }

    //删除单个视频
    @DeleteMapping("removeAliYunVideo/{videoId}")
    public Result removeAliYunVideo(@PathVariable String videoId){
        vodService.removeAliYunVideo(videoId);
        return Result.success();
    }

    @DeleteMapping("removeAliYunVideos")
    public Result removeAliYunVideos(@RequestParam List<String> videoIdList){
        vodService.removeAliYunVideos(videoIdList);
        return Result.success();
    }
}

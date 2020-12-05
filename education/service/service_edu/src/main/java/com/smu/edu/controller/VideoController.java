package com.smu.edu.controller;


import com.smu.base.exception.MyException;
import com.smu.edu.client.VodClient;
import com.smu.edu.domain.Video;
import com.smu.edu.service.VideoService;
import com.smu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caowei
 * @since 2020-11-29
 */
@RestController
@RequestMapping("/edu/video")
@CrossOrigin
public class VideoController {
    @Autowired
    private VideoService videoService;

    @PostMapping("/save-video-info")
    public Result saveVideo(@RequestBody Video video){
        boolean save = videoService.save(video);
        return save? Result.success():Result.error();
    }

    @PostMapping("/updateVideo")
    public Result updateVideo(@RequestBody Video video){
        videoService.updateById(video);
        return Result.success();
    }

    @DeleteMapping("/deleteVideo/{id}")
    public Result deleteVideo(@PathVariable String id){
        //删小节
        int i = videoService.removeVideoById(id);
        if(i == 1){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/getVideo/{videoId}")
    public Result getVideo(@PathVariable String videoId){
        Video byId = videoService.getById(videoId);
        return Result.success().data("video",byId);
    }
}


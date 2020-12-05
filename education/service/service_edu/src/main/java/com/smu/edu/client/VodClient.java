package com.smu.edu.client;

import com.smu.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "service-vod",fallback = VodClientImpl.class)
@Component
public interface VodClient {
    //删除单个视频
    @DeleteMapping("/vod/video/removeAliYunVideo/{videoId}")
    Result removeAliYunVideo(@PathVariable String videoId);

    @DeleteMapping("/vod/video/removeAliYunVideos")
    Result removeAliYunVideos(@RequestParam List<String> videoIdList);
}

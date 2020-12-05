package com.smu.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {
    String uploadAliyunVideo(MultipartFile file);

    void removeAliYunVideo(String videoId);

    void removeAliYunVideos(List<String> videoIdList);
}

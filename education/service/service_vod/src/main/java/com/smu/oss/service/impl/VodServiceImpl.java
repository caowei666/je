package com.smu.oss.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.smu.oss.service.VodService;
import com.smu.oss.utils.ConstantVodUtils;
import com.smu.oss.utils.InitVodClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class VodServiceImpl implements VodService {
    @Override
    public String uploadAliyunVideo(MultipartFile file) {
        try{
            String originalFilename = file.getOriginalFilename();
            String title = originalFilename.substring(0, originalFilename.lastIndexOf("."));
            InputStream inputStream = file.getInputStream();
            UploadStreamRequest request = new UploadStreamRequest(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET, title, originalFilename, inputStream);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            String videoId = null;
            if (response.isSuccess()) {
                videoId = response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                videoId = response.getVideoId();
            }
            return videoId;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void removeAliYunVideo(String videoId) {
        try {
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoId);
            DefaultAcsClient defaultAcsClient = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            defaultAcsClient.getAcsResponse(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeAliYunVideos(List<String> videoIdList) {
        try {
            DeleteVideoRequest request = new DeleteVideoRequest();
            String join = StringUtils.join(videoIdList.toArray(),",");
            request.setVideoIds(join);
            DefaultAcsClient defaultAcsClient = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            defaultAcsClient.getAcsResponse(request);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.smu.oss.controller;

import com.smu.oss.service.OssService;
import com.smu.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/oss/fileoss")
@Api(tags="oss上传")
public class OssController {
    @Resource
    private OssService ossService;

    @PostMapping()
    public Result uploadOssFile(MultipartFile file){
        String url = ossService.uploadFileAvatar(file);
        return Result.success().data("url",url);
    }
}

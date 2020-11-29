package com.smu.edu.controller;


import com.smu.edu.service.SubjectService;
import com.smu.edu.vo.SubjectList;
import com.smu.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caowei
 * @since 2020-11-29
 */
@CrossOrigin
@RestController
@Api(tags="分类管理")
@RequestMapping("/edu/subject")
public class SubjectController {
    @Resource
    private SubjectService subjectService;

    @PostMapping("/addSubject")
    public Result addSubject(MultipartFile file){
        subjectService.saveSubject(file,subjectService);
        return Result.success();
    }

    @GetMapping("/getAllSubject")
    public Result getAllSubject(){
        List<SubjectList> list = subjectService.getAllSubject();
        return Result.success().data("list",list);
    }
}


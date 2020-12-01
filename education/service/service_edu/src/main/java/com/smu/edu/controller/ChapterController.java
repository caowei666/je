package com.smu.edu.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.smu.edu.domain.Chapter;
import com.smu.edu.service.ChapterService;
import com.smu.edu.vo.ChapterList;
import com.smu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caowei
 * @since 2020-11-29
 */
@RestController
@RequestMapping("/edu/chapter")
@CrossOrigin
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @GetMapping("chapterList/{courseId}")
    public Result listChapter(@PathVariable("courseId") String courseId){
        List<ChapterList> list = chapterService.listChapter(courseId);
        return Result.success().data("list",list);
    }

    @PostMapping("/addChapter")
    public Result addChapter(@RequestBody Chapter chapter){
        chapterService.save(chapter);
        return Result.success();
    }

    @GetMapping("/getChapter/{chapterId}")
    public Result getChapter(@PathVariable String chapterId){
        Chapter byId = chapterService.getById(chapterId);
        return Result.success().data("chapter",byId);
    }

    @PostMapping("/updateChapter")
    public Result updateChapter(@RequestBody Chapter chapter){
        chapterService.updateById(chapter);
        return Result.success();
    }
    @DeleteMapping("/deleteChapter/{chapterId}")
    public Result  deleteChapter(@PathVariable String chapterId){
        boolean flag = chapterService.deleteChapter(chapterId);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}


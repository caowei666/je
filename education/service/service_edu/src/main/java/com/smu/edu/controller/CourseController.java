package com.smu.edu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smu.edu.domain.Course;
import com.smu.edu.service.CourseService;
import com.smu.edu.vo.*;
import com.smu.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin
@Api(tags="课程管理")
@RequestMapping("/edu/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourseInfo")
    public Result addCourseInfo(@RequestBody CourseInfo courseInfo){
        String courseId = courseService.saveCourseInfo(courseInfo);
        return Result.success().data("courseId",courseId);
    }

    @GetMapping("/getCourseInfo/{courseId}")
    public Result getCourseInfo(@PathVariable("courseId") String courseId){
        CourseInfo courseInfo = courseService.getCourseInfo(courseId);
        return Result.success().data("courseInfo",courseInfo);
    }

    @PostMapping("/updateCourseInfo")
    public Result updateCourseInfo(@RequestBody CourseInfo courseInfo){
        String s = courseService.updateCourseInfo(courseInfo);
        return Result.success().data("success",s);
    }

    @GetMapping("/getCoursePublishInfo/{courseId}")
    public Result getCoursePublishInfo(@PathVariable String courseId){
        CoursePublishInfo coursePublishInfo = courseService.getCoursePublishInfo(courseId);
        return Result.success().data("coursePublishInfo",coursePublishInfo);
    }

    @GetMapping("publishCourse/{courseId}")
    public Result publishCourse(@PathVariable String courseId){
        Course course = new Course();
        course.setId(courseId);
        course.setStatus("Normal");
        courseService.updateById(course);
        return Result.success();
    }

    @PostMapping("/pageCourseCondition")
    public Result pageCourseCondition(@RequestBody CourseQuery courseQuery){
        PageList<PageInfoList> pageInfoListPageList = courseService.pageCourseList(courseQuery);
        return Result.success().data("pageInfoList",pageInfoListPageList);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public Result deleteCourse(@PathVariable String courseId){
        courseService.removeCourseById(courseId);
        return Result.success();
    }
}


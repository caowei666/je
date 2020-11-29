package com.smu.edu.controller;


import com.smu.edu.service.CourseService;
import com.smu.edu.vo.CourseInfo;
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
}


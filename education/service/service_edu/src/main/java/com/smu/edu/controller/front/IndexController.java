package com.smu.edu.controller.front;

import com.smu.edu.domain.Course;
import com.smu.edu.domain.Teacher;
import com.smu.edu.service.CourseService;
import com.smu.edu.service.TeacherService;
import com.smu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/edu/indexfront")
@CrossOrigin
public class IndexController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/index")
    public Result index(){
        List<Course> courseList = courseService.indexCourse();
        List<Teacher> teacherList = teacherService.indexTeacher();
        return Result.success().data("courseList",courseList).data("teacherList",teacherList);
    }
}

package com.smu.edu.service;

import com.smu.edu.domain.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smu.edu.vo.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caowei
 * @since 2020-11-29
 */
public interface CourseService extends IService<Course> {

    String saveCourseInfo(CourseInfo courseInfo);

    CourseInfo getCourseInfo(String courseId);

    String updateCourseInfo(CourseInfo courseInfo);

    CoursePublishInfo getCoursePublishInfo(String courseId);

    PageList<PageInfoList> pageCourseList(CourseQuery courseQuery);

    void removeCourseById(String courseId);

    List<Course> indexCourse();
}

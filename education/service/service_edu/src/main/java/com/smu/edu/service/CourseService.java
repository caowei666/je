package com.smu.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smu.edu.domain.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smu.edu.vo.*;

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

    PageInfoList pageCourseList(CourseQuery courseQuery);
}

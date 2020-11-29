package com.smu.edu.service;

import com.smu.edu.domain.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smu.edu.vo.CourseInfo;

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
}

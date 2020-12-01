package com.smu.edu.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smu.edu.domain.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smu.edu.vo.CoursePublishInfo;
import com.smu.edu.vo.CourseQuery;
import com.smu.edu.vo.PageInfoList;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caowei
 * @since 2020-11-29
 */
public interface CourseMapper extends BaseMapper<Course> {
    public CoursePublishInfo getCoursePublishInfo(String courseId);

    public PageInfoList getCoursePageList(CourseQuery courseQuery);
}

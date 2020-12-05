package com.smu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smu.base.exception.MyException;
import com.smu.edu.domain.Chapter;
import com.smu.edu.domain.Course;
import com.smu.edu.dao.CourseMapper;
import com.smu.edu.domain.CourseDescription;
import com.smu.edu.service.ChapterService;
import com.smu.edu.service.CourseDescriptionService;
import com.smu.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smu.edu.service.VideoService;
import com.smu.edu.vo.*;
import com.smu.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caowei
 * @since 2020-11-29
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private ChapterService chapterService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Override
    public String saveCourseInfo(CourseInfo courseInfo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseInfo,course);
        int insert = baseMapper.insert(course);
        if(insert == 0){
            throw new MyException(20001,"课程添加失败");
        }
        String cid = course.getId();
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setId(cid);
        courseDescription.setDescription(courseInfo.getDescription());
        courseDescriptionService.save(courseDescription);
        return cid;
    }

    @Override
    public CourseInfo getCourseInfo(String courseId) {
        CourseInfo courseInfo = new CourseInfo();
        Course course = baseMapper.selectById(courseId);
        BeanUtils.copyProperties(course,courseInfo);

        CourseDescription byId = courseDescriptionService.getById(courseId);
        BeanUtils.copyProperties(byId,courseInfo);
        return courseInfo;
    }

    @Override
    public String updateCourseInfo(CourseInfo courseInfo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseInfo,course);
        baseMapper.updateById(course);
        String id = course.getId();

        CourseDescription courseDescription = new CourseDescription();
        BeanUtils.copyProperties(courseInfo,courseDescription);
        courseDescriptionService.updateById(courseDescription);
        return id;
    }

    @Override
    public CoursePublishInfo getCoursePublishInfo(String courseId) {
        CoursePublishInfo coursePublishInfo = baseMapper.getCoursePublishInfo(courseId);
        return coursePublishInfo;
    }

    @Override
    public PageList<PageInfoList> pageCourseList(CourseQuery courseQuery) {
        Long pageNum = (courseQuery.getCurrent() - 1)*courseQuery.getSize();
        courseQuery.setCurrent(pageNum);
        List<PageInfoList> coursePageList = baseMapper.getCoursePageList(courseQuery);
        Long coursePageListTotal = baseMapper.getCoursePageListTotal(courseQuery);
        PageList<PageInfoList> objectPageList = new PageList<>();
        objectPageList.setRecords(coursePageList);
        objectPageList.setTotal(coursePageListTotal);
        return objectPageList;
    }

    @Override
    public void removeCourseById(String courseId) {
        videoService.removeByCourseId(courseId);
        chapterService.removeByCourseId(courseId);
        courseDescriptionService.removeById(courseId);
        int i = baseMapper.deleteById(courseId);
        if(i != 1){
            throw new MyException(20001,"删除课程失败");
        }
    }

    @Cacheable(value = "course",key = "'indexCourseList'")
    @Override
    public List<Course> indexCourse() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("view_count");
        wrapper.last("limit 8");
        List<Course> courseList = baseMapper.selectList(wrapper);
        return courseList;
    }

}

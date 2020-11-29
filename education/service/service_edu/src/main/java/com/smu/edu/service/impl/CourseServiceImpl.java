package com.smu.edu.service.impl;

import com.smu.base.exception.MyException;
import com.smu.edu.domain.Course;
import com.smu.edu.dao.CourseMapper;
import com.smu.edu.domain.CourseDescription;
import com.smu.edu.service.CourseDescriptionService;
import com.smu.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smu.edu.vo.CourseInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

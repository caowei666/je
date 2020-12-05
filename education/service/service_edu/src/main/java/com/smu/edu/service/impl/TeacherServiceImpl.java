package com.smu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smu.edu.domain.Teacher;
import com.smu.edu.dao.TeacherMapper;
import com.smu.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caowei
 * @since 2020-11-25
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Cacheable(value = "teacher",key = "'indexTeacherList'")
    @Override
    public List<Teacher> indexTeacher() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        wrapper.last("limit 4");
        List<Teacher> teacherList = baseMapper.selectList(wrapper);
        return teacherList;
    }
}

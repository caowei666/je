package com.smu.edu.service;

import com.smu.edu.domain.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caowei
 * @since 2020-11-25
 */
public interface TeacherService extends IService<Teacher> {

    List<Teacher> indexTeacher();
}

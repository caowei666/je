package com.smu.edu.service;

import com.smu.edu.domain.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smu.edu.vo.SubjectList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caowei
 * @since 2020-11-29
 */
public interface SubjectService extends IService<Subject> {

    void saveSubject(MultipartFile file, SubjectService subjectService);

    List<SubjectList> getAllSubject();
}

package com.smu.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.smu.edu.domain.Subject;
import com.smu.edu.dao.SubjectMapper;
import com.smu.edu.domain.SubjectData;
import com.smu.edu.listener.SubjectExcelListener;
import com.smu.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smu.edu.vo.SubjectList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public void saveSubject(MultipartFile file, SubjectService subjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class,new SubjectExcelListener(subjectService)).sheet().doRead();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<SubjectList> getAllSubject() {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id","0");
        //List<Subject> oneSubjects = baseMapper.selectList(wrapper);
        List<Subject> oneSubjects = this.list(wrapper);
        List<SubjectList> list = new ArrayList<>();
        for (Subject subject:oneSubjects){
            //封装一级分类
            SubjectList subjectList = new SubjectList();
            BeanUtils.copyProperties(subject,subjectList);
            //封装二级分类
            QueryWrapper<Subject> wrapperTwo = new QueryWrapper<>();
            wrapperTwo.eq("parent_id",subject.getId());
            List<Subject> twoSubject = baseMapper.selectList(wrapperTwo);
            subjectList.setChildren(twoSubject);
            list.add(subjectList);
        }
        return list;
    }
}

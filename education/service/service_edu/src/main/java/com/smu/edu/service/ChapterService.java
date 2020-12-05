package com.smu.edu.service;

import com.smu.edu.domain.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smu.edu.vo.ChapterList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caowei
 * @since 2020-11-29
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterList> listChapter(String courseId);

    boolean deleteChapter(String chapterId);

    void removeByCourseId(String courseId);
}

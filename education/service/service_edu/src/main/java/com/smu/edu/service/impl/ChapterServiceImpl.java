package com.smu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smu.base.exception.MyException;
import com.smu.edu.domain.Chapter;
import com.smu.edu.dao.ChapterMapper;
import com.smu.edu.domain.Video;
import com.smu.edu.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smu.edu.service.VideoService;
import com.smu.edu.vo.ChapterList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private VideoService videoService;

    @Override
    public List<ChapterList> listChapter(String courseId) {
        QueryWrapper<Chapter> chapterwrapper = new QueryWrapper<>();
        chapterwrapper.eq("course_id",courseId);
        chapterwrapper.orderByAsc("sort");
        List<Chapter> chapters = baseMapper.selectList(chapterwrapper);

        QueryWrapper<Video> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("course_id",courseId);
        videoWrapper.orderByAsc("sort");
        List<Video> videos = videoService.list(videoWrapper);

        List<ChapterList> chapterLists = new ArrayList<>();
        for (Chapter chapter: chapters){
            ChapterList chapterList = new ChapterList();
            BeanUtils.copyProperties(chapter,chapterList);
            for (Video video:videos){
                if(video.getChapterId().equals(chapter.getId())){
                    chapterList.getChildren().add(video);
                }
            }
            chapterLists.add(chapterList);
        }
        return chapterLists;
    }

    @Override
    public boolean deleteChapter(String chapterId) {
        QueryWrapper<Video> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.eq("chapter_id",chapterId);
        int count = videoService.count(videoQueryWrapper);
        if(count>0){
            throw new MyException(20001,"不能删除章节");
        }else{
            int i = baseMapper.deleteById(chapterId);
            return i == 1;
        }
    }

    @Override
    public void removeByCourseId(String courseId) {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
}

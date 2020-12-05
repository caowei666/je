package com.smu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smu.base.exception.MyException;
import com.smu.edu.client.VodClient;
import com.smu.edu.domain.Video;
import com.smu.edu.dao.VideoMapper;
import com.smu.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Resource
    private VodClient vodClient;

    @Override
    public int removeVideoById(String id) {
        Video video = baseMapper.selectById(id);
        String videoSourceId = video.getVideoSourceId();
        if(!StringUtils.isEmpty(videoSourceId)){
            Result result = vodClient.removeAliYunVideo(videoSourceId);
            if(result.getCode() == 20001){
                throw new MyException(20001,"删除视频失败");
            }
        }
        int i = baseMapper.deleteById(id);
        return i;
    }

    @Override
    public void removeByCourseId(String courseId) {
        //根据课程id查询所有视频
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        wrapper.select("video_source_id"); //仅返回该字段
        List<Video> videos = baseMapper.selectList(wrapper);
        List<String> videoIds = new ArrayList<>();
        for (Video video:videos){
            String videoSourceId = video.getVideoSourceId();
            if(!StringUtils.isEmpty(videoSourceId)){
                videoIds.add(videoSourceId);
            }
        }
        if(videoIds.size()>0){
            Result result = vodClient.removeAliYunVideos(videoIds);
            if(result.getCode() == 20001){
                throw new MyException(20001,"删除视频失败");
            }
        }
        //根据课程id删除所有小节（一级不包含视频）
        QueryWrapper<Video> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
}

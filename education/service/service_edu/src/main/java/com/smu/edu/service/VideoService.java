package com.smu.edu.service;

import com.smu.edu.domain.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caowei
 * @since 2020-11-29
 */
public interface VideoService extends IService<Video> {

    int removeVideoById(String id);

    void removeByCourseId(String courseId);
}

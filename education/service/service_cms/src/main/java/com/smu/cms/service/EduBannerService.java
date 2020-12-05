package com.smu.cms.service;

import com.smu.cms.domain.EduBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caowei
 * @since 2020-12-04
 */
public interface EduBannerService extends IService<EduBanner> {

    List<EduBanner> getBannerList();
}

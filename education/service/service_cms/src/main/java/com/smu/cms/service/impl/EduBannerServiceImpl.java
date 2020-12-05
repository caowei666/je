package com.smu.cms.service.impl;

import com.smu.cms.domain.EduBanner;
import com.smu.cms.dao.EduBannerMapper;
import com.smu.cms.service.EduBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caowei
 * @since 2020-12-04
 */
@Service
public class EduBannerServiceImpl extends ServiceImpl<EduBannerMapper, EduBanner> implements EduBannerService {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Cacheable(value = "banner",key = "'indexBannerList'")
    @Override
    public List<EduBanner> getBannerList() {
        List<EduBanner> eduBanners = baseMapper.selectList(null);
        redisTemplate.opsForValue().set("eduTest", "eduTest", 100, TimeUnit.SECONDS);
        return eduBanners;
    }
}

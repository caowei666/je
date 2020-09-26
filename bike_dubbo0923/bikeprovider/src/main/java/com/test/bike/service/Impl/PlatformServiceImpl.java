package com.test.bike.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.bike.dao.PlatformDao;
import com.test.bike.pojo.PlatForm;
import com.test.bike.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//引用dubbo的service
@Service
public class PlatformServiceImpl implements PlatformService {
    @Autowired
    private PlatformDao platformDao;

    @Override
    public List<PlatForm> getPlatformList() {
        return platformDao.getPaltformList();
    }
}

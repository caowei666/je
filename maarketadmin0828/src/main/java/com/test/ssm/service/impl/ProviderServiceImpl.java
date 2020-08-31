package com.test.ssm.service.impl;

import com.test.ssm.dao.ProviderDao;
import com.test.ssm.pojo.Provider;
import com.test.ssm.service.ProviderService;
import com.test.ssm.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired(required = false)
    private ProviderDao providerDao;

    @Override
    public ResultData addProvider(Provider provider) {
        try {
            provider.setCreatedDate(new Date());
            providerDao.insert(provider);
            return new ResultData(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(false,e.getMessage());
        }
    }

    @Override
    public List<Provider> getProviderList(String name) {
        return providerDao.getProviderList(name);
    }

    @Override
    public List<Provider> getProName() {
        return providerDao.getProName();
    }
}

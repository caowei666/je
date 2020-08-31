package com.test.ssm.service;

import com.test.ssm.pojo.Provider;
import com.test.ssm.util.ResultData;

import java.util.List;

public interface ProviderService {
    ResultData addProvider(Provider provider);

    List<Provider> getProviderList(String name);

    List<Provider> getProName();
}

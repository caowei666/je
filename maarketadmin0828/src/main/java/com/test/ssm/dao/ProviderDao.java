package com.test.ssm.dao;

import com.test.ssm.pojo.Provider;

import java.util.List;

public interface ProviderDao {
    void insert(Provider provider);

    int update(Provider provider);

    List<Provider> getProviderList(String name);
    List<Provider> getProName();
}

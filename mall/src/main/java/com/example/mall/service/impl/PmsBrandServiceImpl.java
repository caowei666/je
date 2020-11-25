package com.example.mall.service.impl;

import com.example.mall.dao.PmsBrandMapper;
import com.example.mall.pojo.PmsBrand;
import com.example.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired(required = false)
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.getPsmBrandList();
    }

    @Override
    public void createBrand(PmsBrand brand) {
        pmsBrandMapper.addPmsBrandList(brand);
    }

    @Override
    public void updateBrand(PmsBrand brand) {
        pmsBrandMapper.updatePmsBrandList(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        pmsBrandMapper.deletePmsBrandList(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.getPmsBrand(id);
    }
}

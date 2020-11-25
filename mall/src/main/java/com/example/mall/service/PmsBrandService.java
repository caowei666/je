package com.example.mall.service;

import com.example.mall.pojo.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    void createBrand(PmsBrand brand);

    void updateBrand(PmsBrand brand);

    void deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}

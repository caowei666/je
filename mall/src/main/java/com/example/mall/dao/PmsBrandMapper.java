package com.example.mall.dao;

import com.example.mall.pojo.PmsBrand;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PmsBrandMapper {
    List<PmsBrand> getPsmBrandList();

    void addPmsBrandList(PmsBrand pmsBrand);

    void updatePmsBrandList(PmsBrand pmsBrand);

    void deletePmsBrandList(Long pmsBrandId);

    PmsBrand getPmsBrand(long pmsBrandId);
}

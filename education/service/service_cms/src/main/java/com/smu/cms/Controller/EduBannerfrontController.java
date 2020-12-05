package com.smu.cms.Controller;


import com.smu.cms.domain.EduBanner;
import com.smu.cms.service.EduBannerService;
import com.smu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caowei
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/cms/eduFront")
@CrossOrigin
public class EduBannerfrontController {
    @Autowired
    private EduBannerService eduBannerService;

    @GetMapping("/getBannerList")
    public Result getBanner(){
        List<EduBanner> list = eduBannerService.getBannerList();
        return Result.success().data("list",list);
    }
}


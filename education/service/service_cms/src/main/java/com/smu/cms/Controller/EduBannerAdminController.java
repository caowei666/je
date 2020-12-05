package com.smu.cms.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smu.cms.domain.EduBanner;
import com.smu.cms.service.EduBannerService;
import com.smu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caowei
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/cms/eduAdmin")
@CrossOrigin
public class EduBannerAdminController {
    @Autowired
    private EduBannerService eduBannerService;

    @GetMapping("/pageBanner/{current}/{size}")
    public Result pageBanner(@PathVariable long current,@PathVariable long size){
        Page<EduBanner> objectPage = new Page<>(current,size);
        eduBannerService.page(objectPage,null);
        return Result.success().data("total",objectPage.getTotal()).data("lists",objectPage.getRecords());
    }

    @PostMapping("/addBanner")
    public Result addBanner(@RequestBody EduBanner eduBanner){
        boolean save = eduBannerService.save(eduBanner);
        if(save){
            return Result.success();
        }else{
            return Result.error();
        }
    }

    @DeleteMapping("/deleteBanner/{id}")
    public Result deleteBanner(@PathVariable String id){
        boolean b = eduBannerService.removeById(id);
        return b?Result.success():Result.error();
    }

    @GetMapping("/getBanner/{id}")
    public Result getBanner(@PathVariable String id){
        EduBanner byId = eduBannerService.getById(id);
        return Result.success().data("banner",byId);
    }

    @PostMapping("/updateBanner")
    public Result updateBanner(@RequestBody EduBanner eduBanner){
        boolean b = eduBannerService.updateById(eduBanner);
        return b?Result.success():Result.error();
    }
}


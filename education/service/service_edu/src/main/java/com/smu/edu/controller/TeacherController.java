package com.smu.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smu.edu.domain.Teacher;
import com.smu.edu.service.TeacherService;
import com.smu.edu.vo.TeacherQuery;
import com.smu.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caowei
 * @since 2020-11-25
 */
@RestController
@RequestMapping("/edu/teacher")
@Api(tags="讲师管理")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @GetMapping("/findAll")
    @ApiOperation(value = "获取所有讲师列表")
    public Result findAllTeacher(){
        int i = 2/0;
        List<Teacher> list = teacherService.list(null);
        return Result.success().data("items",list);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id逻辑删除讲师")
    public Result deleteTeacher(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable("id") String id){
        boolean b = teacherService.removeById(id);
        if (b){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/pageTeacher/{current}/{size}")
    @ApiOperation(value = "无条件分页查询")
    public Result pageTeacher(@PathVariable("current") Long current,@PathVariable("size") Long size){
        Page page = new Page(current,size);
        teacherService.page(page, null);
        return Result.success().data("total",page.getTotal()).data("rows",page.getRecords());
    }

    @PostMapping("/pageTeacherCondition/{current}/{size}")
    @ApiOperation(value = "多条件组合分页查询讲师")
    public Result pageTeacherCondition(@PathVariable("current") Long current, @PathVariable("size") Long size, @RequestBody(required = false) TeacherQuery teacherQuery){
        Page page = new Page(current,size);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }
        teacherService.page(page,wrapper);
        return Result.success().data("total",page.getTotal()).data("rows",page.getRecords());
    }

    @PostMapping("/addTeacher")
    @ApiOperation(value = "添加讲师")
    public Result addTeacher(@RequestBody(required = false) Teacher teacher){
        boolean save = teacherService.save(teacher);
        if (save){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/getTeacher/{id}")
    @ApiOperation(value = "根据id查询讲师")
    public Result getTeacher(@PathVariable("id") String id){
        Teacher teacher = teacherService.getById(id);
        return Result.success().data("teacher",teacher);
    }

    @PostMapping("/updateTeacher")
    @ApiOperation(value = "更新讲师信息")
    public Result updateTeacher(@RequestBody(required = false) Teacher teacher){
        boolean b = teacherService.updateById(teacher);
        if (b){
            return Result.success();
        }else {
            return Result.error();
        }
    }

}


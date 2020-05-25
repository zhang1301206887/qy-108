package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingProject;
import com.aaa.zk.service.IQYMappingProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "项目管理", tags = "项目信息管理")
public class MappingProjectController extends BaseController {
    @Autowired
    private IQYMappingProjectService iqyMappingProjectService;

    /**
     * @author: gfq
     *  查询所有项目
     * @date: 20-05-25 13:59
     */
    @GetMapping("MappingProjectSelectAll")
    @ApiOperation(value = "查询功能",notes = "查询所有的项目数据")
    ResultData MappingProjectSelectAll(){
        return iqyMappingProjectService.MappingProjectSelectAll();
    }

    /**
     * @author: gfq
     *  新增项目
     * @date: 20-05-25 14:08
     */
    @PostMapping("MappingProjectAdd")
    @ApiOperation(value = "添加功能",notes = "添加新项目数据")
    ResultData MappingProjectAdd( MappingProject mappingProject){
        return iqyMappingProjectService.MappingProjectAdd(mappingProject);
    }

    /**
     * @author: gfq
     * 按条件查询项目数据
     * @date: 20-05-25 14:08
     */
    @PostMapping("MappingProjectSelect")
    @ApiOperation(value = "查询功能",notes = "条件查询项目数据")
    ResultData MappingProjectSelect( MappingProject mappingProject){
        return iqyMappingProjectService.MappingProjectSelect(mappingProject);
    }

    /**
     * @author: gfq
     * 修改项目信息
     * @date: 20-05-25 14:10
     */
    @PostMapping("MappingProjectUpdate")
    @ApiOperation(value = "修改功能",notes = "根据主键id修改项目数据")
    ResultData MappingProjectUpdate( MappingProject mappingProject){
        return iqyMappingProjectService.MappingProjectUpdate(mappingProject);
    }

    /**
     * @author: gfq
     *  删除项目
     * @date: 20-05-25 14:12
     */
    @PostMapping("MappingProjectDelete")
    @ApiOperation(value = "删除功能",notes = "根据主键id删除项目数据")
    ResultData MappingProjectDelete(@RequestBody Object id){
        return iqyMappingProjectService.MappingProjectDelete(id);
    }
}

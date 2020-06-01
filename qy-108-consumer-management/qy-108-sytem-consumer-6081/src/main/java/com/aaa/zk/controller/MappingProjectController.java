package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingProject;
import com.aaa.zk.service.IQYMappingProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "项目管理", tags = "项目信息管理")
public class MappingProjectController extends BaseController {
    @Autowired
    private IQYMappingProjectService iqyMappingProjectService;

    /**
    * @author zk
    * @Date
    *   这个方法是根据userId查询单位的项目数量
    */
    @PostMapping("/selectProjectCountByUserId")
    @ApiOperation(value = "查询功能",notes = "根据userId查询单位项目数量" )
    public ResultData selectProjectCountByUserId(@RequestBody Object userId){
        Integer i = iqyMappingProjectService.selectProjectCountByUserId(userId);

        if (i > 0){
            return super.selelctSuccess(i);
        }else{
            return super.selelctFalied();
        }
    }


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

    /**
     * 这个方法是查询项目完成情况
     * */
    @GetMapping("/selectProjectType")
    @ApiOperation(value = "统计功能",notes= "统计项目完成信息")
    public ResultData selectProjectType(){

        List<Map> mapList = iqyMappingProjectService.selectProjectType();
        System.out.println(mapList);
        if (mapList != null && !"".equals(mapList)){
            return super.selelctSuccess(mapList);
        }else{
            return super.selelctFalied();
        }
    }
    /**
     * @author zk
     * @Date
     *    根据项目成果汇交状态 查询 项目  0:通过 1:未通过 2:已提交 3:未提交
     */
    @GetMapping("/selectByResultsStatus")
    @ApiOperation(value = "查询功能",notes = "根据项目成果汇交状态 查询 项目 ")
    public ResultData selectByResultsStatus(@RequestParam("resultsStatus") Integer resultsStatus){
        List<MappingProject> list = iqyMappingProjectService.selectByResultsStatus(resultsStatus);
        if (null != list){
            return selelctSuccess(list);
        }else {
            return selelctFalied();
        }
    }

}

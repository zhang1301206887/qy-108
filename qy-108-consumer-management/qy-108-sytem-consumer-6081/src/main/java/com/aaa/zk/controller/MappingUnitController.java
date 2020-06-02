package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingUnit;
import com.aaa.zk.service.IQYMappingUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author zk
 * @Date 2020/5/22
 */
@RestController
@Api(value = "单位信息",tags = "单位信息管理")
public class MappingUnitController extends BaseController {

    @Autowired
    private IQYMappingUnitService iqyMappingUnitService;


    /**
    * @author zk
    * @Date
    *   根据单位id
     *   查询 单位人员和项目数量
    */

    @GetMapping("/selectPeopleProjectCountByUnit")
    @ApiOperation(value = "查询功能",notes = "根据单位id查询单位的人员和项目数量")
    public ResultData selectPeopleProjectCountByUnitId(@RequestParam("userId") Integer userId){
        List<Map> maps = iqyMappingUnitService.selectPeopleProjectCountByUnitId(userId);
        if (maps != null && !"".equals(maps)){
            return selelctSuccess(maps);
        }
        return selelctFalied();
    }

    /**
     *查询单位资质等级及数量
     * */
    @GetMapping("/selectCountLevel")
    @ApiOperation(value = "统计功能",notes= "统计单位资质信息" )
    public ResultData selectCountLevel(){
       return iqyMappingUnitService.selectCountLevel();
    }
    /**
    * @author zk
    * @Date
    *   查询单位基本 信息
    */
    @GetMapping("/selectAllUnit")
    @ApiOperation(value = "查询功能",notes = "查询所有单位信息")
    public ResultData selectAllUnit(){
        return iqyMappingUnitService.selectAllUnit();
    }
    @PostMapping("selectUnitByField")
    @ApiOperation(value = "查询功能",notes = "多条件查询单位信息")
    public ResultData selectUnitByField(@RequestBody Map map){
        return iqyMappingUnitService.selectUnitByField(map);
    }
    @GetMapping("selectOneUnit")
    @ApiOperation(value = "查询功能",notes = "根据主键id查询单位信息")
    public ResultData selectOneUnit(@RequestParam("id") Object id){
        return iqyMappingUnitService.selectOneUnit(id);
    }
    @PostMapping("updateUnit")
    @ApiOperation(value = "更新功能",notes = "根据主键id修改单位信息")
    public ResultData updateUnit(@RequestBody MappingUnit mappingUnit){
        return iqyMappingUnitService.updateUnit(mappingUnit);
    }
}

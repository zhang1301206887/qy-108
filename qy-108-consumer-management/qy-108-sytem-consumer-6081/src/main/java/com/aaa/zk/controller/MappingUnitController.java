package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingUnit;
import com.aaa.zk.service.IQYMappingUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
     *查询单位资质等级及数量
     * */
    @GetMapping("/selectCountLevel")
    @ApiOperation(value = "统计功能",notes= "统计单位资质信息" )
    public ResultData selectCountLevel(){
        List<Map> mapList = iqyMappingUnitService.selectCountLevel();
        if (mapList!=null && !mapList.isEmpty()){
            return super.selelctSuccess(mapList);
        }else{
            return super.selelctFalied();
        }
    }
    /**
    * @author zk
    * @Date
    *   查询单位基本 信息
    */
    @GetMapping("/selectAllUnit")
    @ApiOperation(value = "查询功能",notes = "查询所有单位信息")
    public ResultData selectAllUnit(){
        List<MappingUnit> mappingUnitList = iqyMappingUnitService.selectAllUnit();
        if (mappingUnitList!=null && !mappingUnitList.isEmpty()){
            return super.selelctSuccess(mappingUnitList);
        }else{
            return super.selelctFalied();
        }
    }
}

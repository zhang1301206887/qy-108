package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/24 23:42
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Technicist;
import com.aaa.zk.service.IQYTechService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Api(value = "技术人员信息", tags = "技术人员管理")
public class TechController extends BaseController {

    @Autowired
    private IQYTechService techService;

    @GetMapping("selectAllTech")
    @ApiOperation(value = "查询功能",notes = "查询所有技术人员数据")
    public ResultData selectAllTech(){
        return techService.selectAllTech();
    }

    @PostMapping("selectTechByUserId")
    @ApiOperation(value = "查询功能",notes = "根据公司id查询技术人员数据")
    public ResultData selectTechByUserId(@RequestBody HashMap map){
        return techService.selectTechByUserId(map);
    }

    @PostMapping("selectTechByPaimaryKey")
    @ApiOperation(value = "查询功能",notes = "根据id查询技术人员的数据")
    public ResultData selectTechByPrimaryKey(@RequestBody Technicist technicist){
        return techService.selectTechByPrimaryKey(technicist);
    }

    @PutMapping("insertTech")
    @ApiOperation(value = "添加功能",notes = "添加新技术人员数据")
    public ResultData insertTech(@RequestBody Technicist technicist){
        return techService.insertTech(technicist);
    }

    @PostMapping("updateTechByPrimaryKey")
    @ApiOperation(value = "修改功能",notes = "根据主键修改技术人员的数据")
    public ResultData updateTechByPrimaryKey(@RequestBody Technicist technicist){
        return techService.updateTechByPrimaryKey(technicist);
    }

    @DeleteMapping("deleteTechByPaimaryKey")
    @ApiOperation(value = "删除功能",notes = "根据主键删除技术人员数据")
    public ResultData deleteTechByPaimaryKey(@RequestBody Technicist technicist){
        return techService.deleteTechByPaimaryKey(technicist);
    }
}

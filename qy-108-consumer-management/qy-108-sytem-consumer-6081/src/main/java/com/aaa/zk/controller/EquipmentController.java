package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/26 17:15
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Equipment;
import com.aaa.zk.service.IQYEquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "设备信息", tags = "设备信息管理")
public class EquipmentController extends BaseController {
    @Autowired
    private IQYEquipmentService equipmentService;

    @GetMapping("selectEquiByUserId/{userId}")
    @ApiOperation(value = "查询功能",notes = "根据公司id查询设备数据")
    public ResultData selectEquiByUserId(@PathVariable("userId") Object userId){
        return equipmentService.selectEquiByUserId(userId);
    }
    @GetMapping("selectEquiByPrimaryKey/{id}")
    @ApiOperation(value = "查询功能",notes = "根据主键id查询设备数据")
    public ResultData selectEquiByPrimaryKey(@PathVariable("id") Object id){
        return equipmentService.selectEquiByPrimaryKey(id);
    }
    @PutMapping("insertEqui")
    @ApiOperation(value = "添加功能",notes = "添加新设备数据")
    public ResultData insertEqui(@RequestBody Equipment equipment){
        return equipmentService.insertEqui(equipment);
    }
    @PostMapping("updateEquiByPrimaryKey")
    @ApiOperation(value = "修改功能",notes = "根据主键id修改设备数据")
    public ResultData updateEquiByPrimaryKey(@RequestBody Equipment equipment){
        return equipmentService.updateEquiByPrimaryKey(equipment);
    }
    @DeleteMapping("deleteEquiByPrimaryKey/{id}")
    @ApiOperation(value = "删除功能",notes = "根据主键id删除设备数据")
    public ResultData deleteEquiByPrimaryKey(@PathVariable("id") Object id){
        return equipmentService.deleteEquiByPrimaryKey(id);
    }
}

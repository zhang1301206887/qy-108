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

import java.util.Map;

@RestController
@Api(value = "设备信息", tags = "设备信息管理")
public class EquipmentController extends BaseController {
    @Autowired
    private IQYEquipmentService equipmentService;

    @GetMapping("selectEquiByUserId")
    @ApiOperation(value = "查询功能",notes = "根据公司id查询设备数据")
    public ResultData selectEquiByUserId(@RequestParam("userId") Object userId,@RequestParam("pageNo") Integer pageNo,
                                         @RequestParam("pageSize") Integer pageSize){
        return equipmentService.selectEquiByUserId(userId,pageNo,pageSize);
    }

    @GetMapping("selectEquiByPrimaryKey")
    @ApiOperation(value = "查询功能",notes = "根据主键id查询设备数据")
    public ResultData selectEquiByPrimaryKey(@RequestParam("id") Object id){
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

    @DeleteMapping("deleteEquiByPrimaryKey")
    @ApiOperation(value = "删除功能",notes = "根据主键id删除设备数据")
    public ResultData deleteEquiByPrimaryKey(@RequestParam("id") Object id){
        return equipmentService.deleteEquiByPrimaryKey(id);
    }
}

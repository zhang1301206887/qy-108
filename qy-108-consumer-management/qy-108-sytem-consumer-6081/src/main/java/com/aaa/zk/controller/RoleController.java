package com.aaa.zk.controller;
/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 12:04
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Role;
import com.aaa.zk.service.IQYRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "角色信息", tags = "角色信息管理")
public class RoleController extends BaseController {
    @Autowired
    private IQYRoleService roleService;

    @GetMapping("selectAllRole")
    @ApiOperation(value = "查询功能",notes = "查询所有角色数据")
    public ResultData selectAllRole(){
        return roleService.selectAllRole();
    }

    @GetMapping("selectRoleByField")
    @ApiOperation(value = "查询功能",notes = "条件查询角色数据")
    public ResultData selectRoleByField(@RequestBody Role role){
        return roleService.selectRoleByField(role);
    }

    @PutMapping("insertRole")
    @ApiOperation(value = "添加功能",notes = "添加新数据")
    public ResultData insertRole(@RequestBody Role role){
        return roleService.insertRole(role);
    }

    @DeleteMapping("deleteRoleByPrimaryKey")
    @ApiOperation(value = "删除功能",notes = "根据主键id删除角色数据")
    public ResultData deleteRoleByPrimaryKey(@RequestBody Role role){
        return roleService.deleteRoleByPrimaryKey(role);
    }

    @DeleteMapping("deleteRoleByPrimaryKeyList")
    @ApiOperation(value = "删除功能",notes = "根据主键id批量删除角色数据")
    public ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list){
        return roleService.deleteDeptByPrimaryKeyList(list);
    }
}

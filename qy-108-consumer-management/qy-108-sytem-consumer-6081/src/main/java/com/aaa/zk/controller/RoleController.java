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

    @GetMapping("selectRoleByPrimaryKey")
    @ApiOperation(value = "查询功能",notes = "根据主键id查询角色数据")
    public ResultData selectRoleByPrimaryKey(@RequestParam("id") Object id){
        return roleService.selectRoleByPrimaryKey(id);
    }
    @PostMapping("selectRoleByField")
    @ApiOperation(value = "查询功能",notes = "多条件查询角色数据")
    public ResultData selectRoleByField(@RequestBody Map map){
        return roleService.selectRoleByField(map);
    }

    @GetMapping("selectRoleMenuById")
    @ApiOperation(value = "查询功能",notes = "根据角色id查询角色的具体权限")
    public ResultData selectRoleMenuById(@RequestParam("id") Object id){
        return roleService.selectRoleMenuById(id);
    }

    @PutMapping("insertRole")
    @ApiOperation(value = "添加功能",notes = "添加新角色数据")
    public ResultData insertRole(@RequestBody Map map){
        return roleService.insertRole(map);
    }

    @PostMapping("updateRoleByPrimaryKey")
    @ApiOperation(value = "修改功能",notes = "根据角色主键修改角色和对应的权限数据")
    public ResultData updateRoleByPrimaryKey(@RequestBody Map map){return roleService.updateRoleByPrimaryKey(map);}

    @DeleteMapping("deleteRoleByPrimaryKey")
    @ApiOperation(value = "删除功能",notes = "根据主键id删除角色数据")
    public ResultData deleteRoleByPrimaryKey(@RequestParam("id") Object id){
        return roleService.deleteRoleByPrimaryKey(id);
    }

    @DeleteMapping("deleteRoleByPrimaryKeyList")
    @ApiOperation(value = "删除功能",notes = "根据主键id批量删除角色数据")
    public ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list){
        return roleService.deleteRoleByPrimaryKeyList(list);
    }
}

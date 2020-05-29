package com.aaa.zk.controller;
/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 12:04
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Menu;
import com.aaa.zk.service.IQYMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "菜单信息", tags = "菜单信息管理")
public class MenuController extends BaseController {
    @Autowired
    private IQYMenuService menuService;

    @PostMapping("selectMenuByField")
    @ApiOperation(value = "查询功能",notes = "多条件查询菜单数据")
    public ResultData selectMenuByField(@RequestBody Map map){
        return menuService.selectMenuByField(map);
    }

    @GetMapping("selectMenuByPrimaryKey/{id}")
    @ApiOperation(value = "查询功能",notes = "根据主键id查询菜单表数据")
    public ResultData selectMenuByPrimaryKey(@PathVariable("id") Object id){
        return menuService.selectMenuByPrimaryKey(id);
    }

    @GetMapping("selectMenuByParentId/{id}")
    @ApiOperation(value = "查询功能",notes = "查询所有菜单数据")
    public ResultData selectMenuByParentId(@PathVariable("id") Object id){
        return menuService.selectMenuByParentId(id);
    }

    @PutMapping("insertMenu")
    @ApiOperation(value = "添加功能",notes = "添加新数据")
    public ResultData insertMenu(@RequestBody Menu menu){
        return menuService.insertMenu(menu);
    }

    @PostMapping("updateMenuByPrimaryKey")
    @ApiOperation(value = "修改功能",notes = "根据主键id更新菜单数据")
    public ResultData updateMenuByPrimaryKey(@RequestBody Menu menu){
        return menuService.updateMenuByPrimaryKey(menu);
    }

    @DeleteMapping("deleteMenuByPrimaryKey")
    @ApiOperation(value = "删除功能",notes = "根据主键id删除菜单数据")
    ResultData deleteMenuByPrimaryKey(@RequestBody Object id){
        return menuService.deleteMenuByPrimaryKey(id);
    }

    @DeleteMapping("deleteMenuByPrimaryKeyList")
    @ApiOperation(value = "删除功能",notes = "根据主键id批量删除菜单数据")
    ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list){
        return menuService.deleteMenuByPrimaryKeyList(list);
    }
}

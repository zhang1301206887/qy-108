package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/26 15:02
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Principal;
import com.aaa.zk.service.IQYPrincipalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "负责人信息", tags = "负责人信息管理")
public class PrincipalController extends BaseController {
    @Autowired
    private IQYPrincipalService principalService;

    @GetMapping("selectPrinByUserId/{userId}")
    @ApiOperation(value = "查询功能",notes = "根据公司id查询负责人数据")
    public ResultData selectPrinByUserId(@PathVariable("userId") Object userId){
        return principalService.selectPrinByUserId(userId);
    }

    @GetMapping("selectPrinByPrimaryKey/{id}")
    @ApiOperation(value = "查询功能",notes = "根据主键id查询负责人数据")
    public ResultData selectPrinByPrimaryKey(@PathVariable("id") Object id){
        return principalService.selectPrinByPrimaryKey(id);
    }

    @PutMapping("insertPrin")
    @ApiOperation(value = "添加功能",notes = "添加新负责人数据")
    public ResultData insertPrin(@RequestBody Principal principal){
        return principalService.insertPrin(principal);
    }

    @PostMapping("updatePrinByPrimaryKey")
    @ApiOperation(value = "修改功能",notes = "根据主键id修改负责人数据")
    public ResultData updatePrinByPrimaryKey(@RequestBody Principal principal){
        return principalService.updatePrinByPrimaryKey(principal);
    }

    @DeleteMapping("deletePrinByPrimaryKey")
    @ApiOperation(value = "删除功能",notes = "根据主键id删除负责人数据")
    public ResultData deletePrinByPrimaryKey(@RequestBody Long id){
        return principalService.deletePrinByPrimaryKey(id);
    }
}

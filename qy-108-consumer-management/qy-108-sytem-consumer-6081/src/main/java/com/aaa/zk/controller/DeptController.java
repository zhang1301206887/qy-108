package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 11:29
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Dept;
import com.aaa.zk.service.IQYDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "部门信息", tags = "部门信息管理")
public class DeptController extends BaseController {

    @Autowired
    private IQYDeptService deptService;

    /**
    * @Author: He create on 2020/5/22 11:33
    * @param: []
    * @return: com.aaa.zk.base.ResultData
    * @Description: 查询所有部门信息
    */
    @GetMapping("/selectAllDept")
    @ApiOperation("查询所有部门信息")
    public ResultData selectAll(){
        return deptService.selectAll();
    }

    @GetMapping("/selectDeptByField")
    @ApiOperation("根据条件查询部门信息")
    public ResultData selectDeptByField(@RequestBody Dept dept){
        return deptService.selectByField(dept);
    }

}

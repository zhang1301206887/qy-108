package com.aaa.zk.controller;
/*
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @ApiOperation(value = "查询功能",notes = "查询所有的部门数据")
    public ResultData selectAll(){
        return deptService.selectAllDept();
    }

    /**
    * @Author: He create on 2020/5/26 14:52
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id查询部门数据
    */
    @GetMapping("selectDeptByPrimaryKey/{id}")
    @ApiOperation(value = "查询功能",notes = "根据主键id查询部门数据")
    public ResultData selectDeptByPrimaryKey(@PathVariable("id") Object id){
        return deptService.selectDeptByPrimaryKey(id);
    }
    /**
    * @Author: He create on 2020/5/22 11:45
    * @param: [dept]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 条件查询
    */
    @PostMapping("/selectDeptByField")
    @ApiOperation(value = "查询功能",notes = "条件查询部门数据")
    public ResultData selectDeptByField(@RequestBody Dept dept){
        return deptService.selectDeptByField(dept);
    }
    /**
    * @Author: He create on 2020/5/22 11:48
    * @param: [dept]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加新部门
    */
    @PutMapping("/insertDept")
    @ApiOperation(value = "添加功能",notes = "添加新部门数据")
    public ResultData insertDept(@RequestBody Dept dept){
        return deptService.insertDept(dept);
    }
    /**
    * @Author: He create on 2020/5/22 11:48
    * @param: [dept]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id修改部门信息
    */
    @PostMapping("updateDeptByPrimaryKey")
    @ApiOperation(value = "更新功能",notes = "根据主键id更新部门数据")
    public ResultData updateByPrimaryKey(@RequestBody Dept dept){
        return deptService.updateDeptByPrimaryKey(dept);
    }
    /**
    * @Author: He create on 2020/5/22 11:48
    * @param: [dept]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id删除部门
    */
    @DeleteMapping("deleteDeptByPrimaryKey")
    @ApiOperation(value = "删除功能",notes = "根据主键id删除部门数据")
    public ResultData deleteByPrimaryKey(@RequestBody Object id){
        return deptService.deleteDeptByPrimaryKey(id);
    }
    /**
    * @Author: He create on 2020/5/22 11:48
    * @param: [list]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id批量删除
    */
    @DeleteMapping("deleteDeptByPrimaryKeyList")
    @ApiOperation(value = "删除功能",notes = "根据主键id批量删除部门数据")
    public ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list){
        return deptService.deleteDeptByPrimaryKeyList(list);
    }

}

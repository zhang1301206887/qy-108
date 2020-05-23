package com.aaa.zk.controller;
/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/20 17:33
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Dept;
import com.aaa.zk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
public class DeptController extends BaseController {
    @Autowired
    private DeptService deptService;

    /**
    * @Author: He create on 2020/5/20 18:05
    * @param: []
    * @return: java.util.List<com.aaa.zk.model.Dept>
    * @Description: 查询所有部门信息
    */
    @GetMapping("/selectAllDept")
    public ResultData selectAll(){
        List<Dept> depts = deptService.selectAllDept();
        if (null != depts){
            return selelctSuccess(depts);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/20 17:50
    * @param: [dept]
    * @return: com.aaa.zk.model.Dept
    * @Description: 根据部门名称 查询部门基本信息
    */
    @PostMapping("/selectDeptByField")
    public ResultData selectByField(@RequestBody Dept dept){
        List<Dept> depts = deptService.selectDeptByName(dept);
        if (null != dept && depts.size() > 0){
            return selelctSuccess(depts);
        }
       return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/20 17:56
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 新增部门
    */
    @PutMapping("/insertDept")
    public ResultData insertDept(@RequestBody Dept dept){
        Integer insertResult = deptService.insertDept(dept);
        if (insertResult > 0){
            return insertSuccess();
        }
        return insertFalied();
    }
    /**
    * @Author: He create on 2020/5/20 17:59
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 根据主键id 修改部门信息
    */
    @PostMapping("updateDeptByPrimaryKey")
    public ResultData updateByPrimaryKey(@RequestBody Dept dept){
        Integer updateResult = deptService.updateDeptByPrimaryKey(dept);
        if (updateResult > 0 ){
            return updataSuccess();
        }
        return updateFalied();
    }
    /**
    * @Author: He create on 2020/5/20 17:59
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 根据主键id 删除部门
    */
    @DeleteMapping("deleteDeptByPrimaryKey")
    public ResultData deleteByPrimaryKey(@RequestBody Object id){
        Integer deleteResult = deptService.deleteDeptByPrimaryKey(id);
        if (deleteResult > 0){
            return deleteSuccess();
        }
        return deleteFalied();
    }
    /**
    * @Author: He create on 2020/5/21 23:25
    * @param: [list]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据前台传入的list  遍历map id 进行删除操作
    */
    @DeleteMapping("deleteDeptByPrimaryKeyList")
    public ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list){
        Integer integer = deptService.deleteDeptByPrimaryKeyList(list);
        if (integer > 0){
            return deleteSuccess("删除成功，共"+integer+"数据！");
        }
        return deleteFalied();
    }
}

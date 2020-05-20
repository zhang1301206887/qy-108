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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController("dept")
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
        List<Dept> depts = deptService.selectAll();
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
    @GetMapping("/selectDeptByField")
    public ResultData selectByField(@RequestBody Dept dept){
        dept.setDeptName("开发部");
        Dept dept1 = deptService.selectByName(dept);
        if (null != dept1){
            return selelctSuccess(dept1);
        }
       return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/20 17:56
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 新增部门
    */
    @GetMapping("/insertDept")
    public ResultData insertDept(@RequestBody Dept dept){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(new Date());
        dept.setDeptName("测试");
        dept.setParentId(1L);
        dept.setOrderNum(6.0);
        dept.setCreateTime(nowtime);
        Integer insertResult = deptService.insert(dept);
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
    @GetMapping("updateDeptByPrimaryKey")
    public ResultData updateByPrimaryKey(@RequestBody Dept dept){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(new Date());
        dept.setDeptName("修改测试");
        dept.setParentId(2L);
        dept.setId(9L);
        dept.setModifyTime(nowtime);
        Integer updateResult = deptService.updateByPrimaryKey(dept);
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
    @GetMapping("deleteDeptByPrimaryKey")
    public ResultData deleteByPrimaryKey(@RequestBody Dept dept){
        dept.setId(10L);
        Integer deleteResult = deptService.deleteByPrimaryKey(dept);
        if (deleteResult > 0){
            return deleteSuccess();
        }
        return deleteFalied();
    }
}

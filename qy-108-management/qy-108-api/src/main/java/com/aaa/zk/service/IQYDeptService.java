package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 11:28
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "dept-interface")
public interface IQYDeptService {
    /**
     * @Author: He create on 2020/5/22 9:54
     * @param: []
     * @return: com.aaa.zk.base.ResultData
     * @Description: 查询所有部门信息  和provider中的deptcontroller对应
     */
    @GetMapping("/selectAllDept")
    ResultData selectAll();

    /**
     * @Author: He create on 2020/5/22 9:55
     * @param: [dept]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据条件查询信息
     */
    @GetMapping("/selectDeptByField")
    ResultData selectByField(@RequestBody Dept dept);

    /**
     * @Author: He create on 2020/5/22 9:55
     * @param: [dept]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 添加新部门
     */
    @PutMapping("/insertDept")
    ResultData insertDept(@RequestBody Dept dept);

    /**
     * @Author: He create on 2020/5/22 9:56
     * @param: [dept]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id更新数据
     */
    @PostMapping("updateDeptByPrimaryKey")
    ResultData updateByPrimaryKey(@RequestBody Dept dept);

    /**
     * @Author: He create on 2020/5/22 9:56
     * @param: [dept]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id删除 一条数据
     */
    @DeleteMapping("deleteDeptByPrimaryKey")
    ResultData deleteByPrimaryKey(@RequestBody Dept dept);
    /**
     * @Author: He create on 2020/5/22 9:57
     * @param: [list]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 批量删除
     */
    @DeleteMapping("deleteDeptByPrimaryKeyList")
    ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list);
}

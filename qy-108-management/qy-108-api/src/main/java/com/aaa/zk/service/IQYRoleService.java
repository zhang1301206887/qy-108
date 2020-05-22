package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 12:03
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(value = "role-interface")
public interface IQYRoleService {
    @GetMapping("selectAllRole")
    public ResultData selectAllRole();
    @GetMapping("selectRoleByField")
    public ResultData selectRoleByField(@RequestBody Role role);
    @PutMapping("insertRole")
    public ResultData insertRole(@RequestBody Role role);
    @DeleteMapping("deleteRoleByPrimaryKey")
    public ResultData deleteRoleByPrimaryKey(@RequestBody Role role);
    @DeleteMapping("deleteRoleByPrimaryKeyList")
    public ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list);
}

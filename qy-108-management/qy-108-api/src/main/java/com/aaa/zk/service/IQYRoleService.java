package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 12:03
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "role-interface")
public interface IQYRoleService {
    /**
    * @Author: He create on 2020/5/23 10:45
    * @param: []
    * @return: com.aaa.zk.base.ResultData
    * @Description: 查询所有角色信息
    */
    @GetMapping("selectAllRole")
    ResultData selectAllRole();

    /**
    * @Author: He create on 2020/5/26 15:00
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id查询角色数据
    */
    @GetMapping("selectRoleByPrimaryKey")
    public ResultData selectRoleByPrimaryKey(@RequestParam("id") Object id);
    /**
    * @Author: He create on 2020/5/23 10:45
    * @param: [role]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据条件查询角色信息
    */
    @PostMapping("selectRoleByField")
    ResultData selectRoleByField(@RequestBody Map map);
    /**
    * @Author: He create on 2020/5/23 10:45
    * @param: [map]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加新角色
    */
    @PutMapping("insertRole")
    ResultData insertRole(@RequestBody Map map);
    /**
    * @Author: He create on 2020/5/23 10:45
    * @param: [map]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id修改角色信息
    */
    @PostMapping("updateRoleByPrimaryKey")
    ResultData updateRoleByPrimaryKey(@RequestBody Map map);
    /**
     * @Author: He create on 2020/5/22 12:07
     * @param: [menu]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id删除一条数据
     */
    @DeleteMapping("deleteRoleByPrimaryKey")
    public ResultData deleteRoleByPrimaryKey(@RequestParam("id") Object id);
    /**
     * @Author: He create on 2020/5/22 12:08
     * @param: [list]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id批量删除角色信息
     */
    @DeleteMapping("deleteRoleByPrimaryKeyList")
    ResultData deleteRoleByPrimaryKeyList(@RequestBody List<Map> list);
    /**
    * @Author: He create on 2020/5/23 10:46
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据角色id查询具体的角色权限信息
    */
    @GetMapping("selectRoleMenuById")
    public ResultData selectRoleMenuById(@RequestParam("id") Object id);
}

package com.aaa.zk.controller;
/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/21 22:02
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Role;
import com.aaa.zk.model.RoleMenu;
import com.aaa.zk.service.RoleMenuService;
import com.aaa.zk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuService roleMenuService;
    /**
    * @Author: He create on 2020/5/21 23:01
    * @param: []
    * @return: com.aaa.zk.base.ResultData
    * @Description: 查询所有角色信息
    */
    @GetMapping("selectAllRole")
    public ResultData selectAllRole(){
        List<Role> roles = roleService.selectAllRole();
        if (null != roles){
            return selelctSuccess(roles);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/21 23:01
    * @param: [role]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据条件 查询角色信息
    */
    @GetMapping("selectRoleByField")
    public ResultData selectRoleByField(@RequestBody Role role){
        List<Role> roles = roleService.selectOneRole(role);
        if (null != roles){
            return selelctSuccess(roles);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/22 15:04
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据角色的id查询角色的权限信息
    */
    @GetMapping("selectRoleMenuById")
    public ResultData selectRoleMenuById(@RequestParam Object id){
        List<RoleMenu> roleMenus = roleMenuService.selectRoleMenuById(id);
        if (null != roleMenus){
            return selelctSuccess(roleMenus);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/21 23:00
    * @param: [role]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加角色
    */
    @PutMapping("insertRole")
    public ResultData insertRole(@RequestBody Role role){
        Integer insertRole = roleService.insertRole(role);
        if (insertRole > 0){
            return insertSuccess();
        }
        return insertFalied();
    }
    /**
    * @Author: He create on 2020/5/21 23:00
    * @param: [role]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id删除单个用户
    */
    @DeleteMapping("deleteRoleByPrimaryKey")
    public ResultData deleteRoleByPrimaryKey(@RequestBody Role role){
        Integer deleteRoleByPrimaryKey = roleService.deleteRoleByPrimaryKey(role);
        if (deleteRoleByPrimaryKey > 0){
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
    @DeleteMapping("deleteRoleByPrimaryKeyList")
    public ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list){
        Integer deleteRoleByPrimaryKeyList = roleService.deleteRoleByPrimaryKeyList(list);
        if (deleteRoleByPrimaryKeyList > 0){
            return deleteSuccess("删除成功,共"+ deleteRoleByPrimaryKeyList +"数据！");
        }
        return deleteFalied();
    }
}

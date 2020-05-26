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
    * @Author: He create on 2020/5/26 14:47
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id查询角色数据
    */
    @GetMapping("selectRoleByPrimaryKey/{id}")
    public ResultData selectRoleByPrimaryKey(@PathVariable("id") Object id){
        Role role = roleService.selectRoleByPrimaryKey(id);
        if (null != role){
            return selelctSuccess(role);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/21 23:01
    * @param: [role]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据条件 查询角色信息
    */
    @PostMapping("selectRoleByField")
    public ResultData selectRoleByField(@RequestBody Role role){
        List<Role> roles = roleService.selectRoleByFeild(role);
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
    @GetMapping("selectRoleMenuById/{id}")
    public ResultData selectRoleMenuById(@PathVariable("id") Object id){
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
    public ResultData insertRole(@RequestBody Map map){
        //前台传入map 数据 需要取出后放入实体类中进行添加
        Role role = new Role().setRoleName(map.get("roleName").toString()).setRemark(map.get("remark").toString());
        //此时返回的时 添加生成的主键id
        Long insertRole = roleService.insertRole(role);
        if (null != insertRole && insertRole > 0){
            Integer insert = 0;
            //获取前台传入的数据 因为map中获取的时object类型 转化为string并且去除空格
            String xx = map.get("xx").toString().replaceAll(" ","");
            //将string转化为数组 因string格式为"[1,2,3]" 去除边框[]为"1,2,3" 并且以,为分割转化为数组
            // 便于遍历进行权限表的添加数据
            String[] arr = xx.substring(1,xx.length()-1).split(",");
            //遍历arr中的权限id 进行权限的添加
            for (int i = 0; i < arr.length ; i++) {
                //将数组遍历 取出的权限id转化为Long类型
                Long menuId = Long.valueOf(arr[i]);
                //添加到角色权限中间表中
                RoleMenu roleMenu = new RoleMenu().setRoleId(insertRole).setMenuId(menuId);
                Integer integer = roleMenuService.insertRoleMenu(roleMenu);
                insert += integer;
            }
            if (insert > 0){
                return insertSuccess();
            }
            return insertFalied();
        }
        return insertFalied();
    }
    /**
    * @Author: He create on 2020/5/23 10:41
    * @param: [map]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据前台传输的数据修改角色的信息和对应权限的信息
    */
    @PostMapping("updateRoleByPrimaryKey")
    public ResultData updateRoleByPrimaryKey(@RequestBody Map map){
        Role role = new Role();
        role.setRoleName(map.get("roleName").toString()).setRemark(map.get("remark").toString()).setId(Long.valueOf(map.get("id").toString()));
        Integer updateRoleByPrimaryKey = roleService.updateRoleByPrimaryKey(role);
        if (updateRoleByPrimaryKey > 0){
            Integer deleteMenuByRoleId = roleMenuService.deleteMenuByRoleId(map.get("id"));
            if (deleteMenuByRoleId > 0){
                Integer insert = 0;
                //获取前台传入的数据 因为map中获取的时object类型 转化为string并且去除空格
                String xx = map.get("xx").toString().replaceAll(" ","");
                //将string转化为数组 因string格式为"[1,2,3]" 去除边框[]为"1,2,3" 并且以,为分割转化为数组
                // 便于遍历进行权限表的添加数据
                String[] arr = xx.substring(1,xx.length()-1).split(",");
                //遍历arr中的权限id 进行权限的添加
                for (int i = 0; i < arr.length ; i++) {
                    //将数组遍历 取出的权限id转化为Long类型
                    Long menuId = Long.valueOf(arr[i]);
                    //添加到角色权限中间表中
                    RoleMenu roleMenu = new RoleMenu().setRoleId(Long.valueOf(map.get("id").toString())).setMenuId(menuId);
                    Integer integer = roleMenuService.insertRoleMenu(roleMenu);
                    insert += integer;
                }
                if (insert > 0){
                    return updataSuccess();
                }
            }
        }
        return updateFalied();
    }
    /**
    * @Author: He create on 2020/5/21 23:00
    * @param: [role]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id删除单个角色 并且删除角色权限表中的数据
    */
    @DeleteMapping("deleteRoleByPrimaryKey/{id}")
    public ResultData deleteRoleByPrimaryKey(@PathVariable("id") Object id){
        Integer deleteRoleByPrimaryKey = roleService.deleteRoleByPrimaryKey(id);
        if (deleteRoleByPrimaryKey > 0){
            Integer delete = roleMenuService.deleteMenuByRoleId(id);
            if (delete > 0){
                return deleteSuccess();
            }
           return deleteFalied();
        }
        return deleteFalied();
    }
    /**
     * @Author: He create on 2020/5/21 23:25
     * @param: [list]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据前台传入的list  遍历map id进行删除操作
     */
    @DeleteMapping("deleteRoleByPrimaryKeyList")
    public ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list){
        Integer deleteRoleByPrimaryKeyList = roleService.deleteRoleByPrimaryKeyList(list);
        if (deleteRoleByPrimaryKeyList > 0){
            Integer integer = roleMenuService.deleteMenuByRoleIdList(list);
            if (integer > 0){
                return deleteSuccess("删除成功,共"+ deleteRoleByPrimaryKeyList +"角色数据");
            }
        }
        return deleteFalied();
    }
}

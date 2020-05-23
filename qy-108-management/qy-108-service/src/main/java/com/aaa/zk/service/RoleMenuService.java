package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 14:38
 *@Description:
 */

import com.aaa.zk.mapper.RoleMenuMapper;
import com.aaa.zk.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
    * @Author: He create on 2020/5/22 21:30
    * @param: [id]
    * @return: java.util.List<com.aaa.zk.model.RoleMenu>
    * @Description: 查询角色的具体权限
    */
    public List<RoleMenu> selectRoleMenuById(Object id){
        if (null != id){
            List<RoleMenu> select = roleMenuMapper.selectRoleMenuById(id);
            List<RoleMenu> roleMenus = roleMenuMapper.selectRoleMenuById(1);
            System.out.println(roleMenus);
            if (null != select && select.size() > 0){
                return select;
            }
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/22 21:30
    * @param: [id]
    * @return: java.lang.Integer
    * @Description: 修改角色权限时  删除权限
    */
    public Integer deleteMenuByRoleId(Object roleId){
        if (null != roleId){
            Integer delete = roleMenuMapper.deleteByRoleId(roleId);
            if (delete > 0){
                return delete;
            }
        }
        return 0;
    }
    public Integer deleteMenuByRoleIdList(List<Map> list){
        if (null != list && list.size() > 0){
            Integer deleteNum = 0;
            //循环遍历list中的map 取出其中的id进行删除操作
            for (Map map : list){
                Object id = map.get("id");
                int deleteResult = roleMenuMapper.deleteByRoleId(id);
                if (deleteResult > 0){
                    deleteNum += 1;
                }
            }
            return deleteNum;
        }
        return 0;
    }
    /**
    * @Author: He create on 2020/5/22 21:31
    * @param: []
    * @return: java.lang.Integer
    * @Description: 添加角色的权限
    */
    public Integer insertRoleMenu(RoleMenu roleMenu){
        if (null != roleMenu){
            int insert = roleMenuMapper.insert(roleMenu);
            if (insert > 0){
                return insert;
            }
        }
        return 0;
    }
}

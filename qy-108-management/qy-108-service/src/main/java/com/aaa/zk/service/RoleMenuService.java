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

@Service
public class RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    public List<RoleMenu> selectRoleMenuById(Object id){
        if (null != id){
            List<RoleMenu> select = roleMenuMapper.selectRoleMenuById(id);
            if (null != select && select.size() > 0){
                return select;
            }
        }
        return null;
    }
    public Integer deleteByRoleId(Object id){
        if (null != id){
            Integer delete = roleMenuMapper.deleteByRoleId(id);
            if (delete > 0){
                return delete;
            }
        }
        return 0;
    }
    public Integer insertRoleMenu(){
        return null;
    }
}

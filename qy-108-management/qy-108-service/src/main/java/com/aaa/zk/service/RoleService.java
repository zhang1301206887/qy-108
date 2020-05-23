package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/21 16:20
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.RoleMapper;
import com.aaa.zk.mapper.RoleMenuMapper;
import com.aaa.zk.model.Role;
import com.aaa.zk.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Service
public class RoleService extends BaseService<Role> {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    private String nowDate = new DateUtil().getNowDate();
    /**
    * @Author: He create on 2020/5/21 22:16
    * @param: [role]
    * @return: java.util.List<com.aaa.zk.model.Role>
    * @Description: 根据字段 查询角色信息
    */
    public List<Role> selectOneRole(Role role){
        if (null != role){
            List<Role> select = roleMapper.select(role);
            if (null != select && select.size() > 0){
                return select;
            }
        }
        return null;
    }

    /**
    * @Author: He create on 2020/5/21 22:16
    * @param: []
    * @return: java.util.List<com.aaa.zk.model.Role>
    * @Description: 查询所有的角色信息
    */
    public List<Role> selectAllRole(){
        List<Role> roles = roleMapper.selectAll();
        if ( null != roles && roles.size() > 0){
            return roles;
        }
        return null;
    }

    /**
    * @Author: He create on 2020/5/21 22:17
    * @param: [role]
    * @return: java.lang.Integer
    * @Description: 添加角色
    */
    public Long insertRole(Role role){
        if (null != role){
            role.setCreateTime(nowDate);
            Integer integer = roleMapper.insertRoleResultId(role);
            @NotNull Long id = role.getId();
            if (null != integer){
                return id;
            }
        }
        return 0L;
    }
    /**
    * @Author: He create on 2020/5/23 10:26
    * @param: [role]
    * @return: java.lang.Integer
    * @Description: 根据主键id修改角色信息
    */
    public Integer updateRoleByPrimaryKey(Role role){
        if (null != role){
            //模拟时间
            role.setCreateTime(nowDate).setModifyTime(nowDate);
            int update = roleMapper.updateByPrimaryKey(role);
            if (update > 0){
                return update;
            }
        }
        return 0;
    }
    /**
    * @Author: He create on 2020/5/21 22:17
    * @param: [id]
    * @return: java.lang.Integer
    * @Description: 根据主键id删除数据
    */
    public Integer deleteRoleByPrimaryKey(Object roleId){
        if (null != roleId){
            int deleteResult = roleMapper.deleteByPrimaryKey(roleId);
            if (deleteResult > 0){
                return deleteResult;
            }
        }
        return 0;
    }
    /**
     * @Author: He create on 2020/5/21 23:07
     * @param: [map]
     * @return: java.lang.Integer
     * @Description: 通过主键id批量删除数据
     */
    public Integer deleteRoleByPrimaryKeyList(List<Map> list){
        if (null != list && list.size()>0){
            Integer deleteNum = 0;
            //循环遍历list中的map 取出其中的id进行删除操作
            for (Map map : list){
                Object id = map.get("id");
                int deleteResult = roleMapper.deleteByPrimaryKey(id);
                if (deleteResult > 0){
                    deleteNum += 1;
                }
            }
            return deleteNum;
        }
        return 0;
    }
}

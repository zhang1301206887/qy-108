package com.aaa.zk.mapper;

import com.aaa.zk.model.RoleMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMenuMapper extends Mapper<RoleMenu> {


    List<RoleMenu> selectRoleMenuById(Object id);


    Integer deleteByRoleId(Object roleId);

}
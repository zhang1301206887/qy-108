package com.aaa.zk.mapper;


import com.aaa.zk.model.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {
    Integer insertRoleResultId(Role role);
    List<Role> selectRoleByField(Map map);
}
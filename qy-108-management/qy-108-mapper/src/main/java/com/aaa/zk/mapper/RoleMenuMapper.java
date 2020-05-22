package com.aaa.zk.mapper;

import com.aaa.zk.model.RoleMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMenuMapper extends Mapper<RoleMenu> {

    @Select("select * from t_role_menu where role_id = #{roleId}")
    List<RoleMenu> selectRoleMenuById(Object id);

    @Delete("delete from t_role_menu where role_id = #{roleId}")
    Integer deleteByRoleId(Object id);

}
package com.aaa.zk.mapper;


import com.aaa.zk.model.Menu;
import com.aaa.zk.vo.MenuVo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {

    @Select("select * from t_menu where parent_id = #{parent_id}")
    List<MenuVo> selectMenuByParentId(Object parentId);

}
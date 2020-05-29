package com.aaa.zk.mapper;


import com.aaa.zk.model.Menu;
import com.aaa.zk.vo.MenuVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface MenuMapper extends Mapper<Menu> {

    List<MenuVo> selectMenuByParentId(Object parentId);
    List<Menu> selectMenuByField(Map map);
}
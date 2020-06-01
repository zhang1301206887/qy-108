package com.aaa.zk.mapper;


import com.aaa.zk.model.Dept;
import com.aaa.zk.vo.DeptVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends Mapper<Dept> {
    List<Dept> selectDeptByField(Map map);
    List<DeptVo> selectAllDept(Object id);
}
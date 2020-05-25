package com.aaa.zk.mapper;

import com.aaa.zk.model.MappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface MappingProjectMapper extends Mapper<MappingProject> {

    //对项目类型进行统计
    List<Map> selectProjectType();

    //根据user_id查询单位项目数量
    Integer selectProjectCountByUserId(Object userId);
}
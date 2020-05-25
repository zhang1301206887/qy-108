package com.aaa.zk.mapper;

import com.aaa.zk.model.MappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface MappingProjectMapper extends Mapper<MappingProject> {
    List<Map> selectProjectType();
}
package com.aaa.zk.mapper;

import com.aaa.zk.model.Resource;
import com.aaa.zk.model.Technicist;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TechnicistMapper extends Mapper<Technicist> {

    List<Map> selectTechByUserId(Object userId);

    List<Resource> selectResourceById(Object id);

    List<Map> selectTechCountByUserId(Object userId);
}
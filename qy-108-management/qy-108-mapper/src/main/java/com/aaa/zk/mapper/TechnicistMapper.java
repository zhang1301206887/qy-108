package com.aaa.zk.mapper;

import com.aaa.zk.model.Technicist;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TechnicistMapper extends Mapper<Technicist> {

    List<Technicist> selectTechByUserId(Object userId);

}
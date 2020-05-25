package com.aaa.zk.mapper;

import com.aaa.zk.model.MappingUnit;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;
import java.util.Map;

public interface MappingUnitMapper extends Mapper<MappingUnit> {
    List<Map> selectCountLevel();

}
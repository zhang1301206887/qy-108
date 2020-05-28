package com.aaa.zk.mapper;

import com.aaa.zk.model.MappingUnit;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;
import java.util.Map;

public interface MappingUnitMapper extends Mapper<MappingUnit> {

    //查询单位资质等级及数量
    List<Map> selectCountLevel();
    /**
     * 根据id进行单位分值的增加
     * */
    Integer updateInsertScoreById(MappingUnit mappingUnit);
    /**
     * 根据id进行单位分值的减少
     * */
    Integer updateDeleteScoreById(MappingUnit mappingUnit);
}
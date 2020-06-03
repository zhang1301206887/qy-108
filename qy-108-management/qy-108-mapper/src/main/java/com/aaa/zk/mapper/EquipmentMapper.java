package com.aaa.zk.mapper;

import com.aaa.zk.model.Equipment;
import com.aaa.zk.model.Resource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface EquipmentMapper extends Mapper<Equipment> {
    List<Equipment> selectEquiByUserId(Object userId);
    List<Resource> selectResourceById(Object id);
}
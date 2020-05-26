package com.aaa.zk.mapper;

import com.aaa.zk.model.Equipment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EquipmentMapper extends Mapper<Equipment> {
    List<Equipment> selectEquiByUserId(Object userId);
}
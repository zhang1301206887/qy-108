package com.aaa.zk.mapper;

import com.aaa.zk.model.Resource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ResourceMapper extends Mapper<Resource> {

    //根据项目id查询该项目的附件材料信息
    List<Resource> selectResourceByRefBizId(Object id);
    //根据类型和单位id查询附件信息
    Resource selectResourceByIdAndType(Map map);

}
package com.aaa.zk.mapper;


import com.aaa.zk.model.Dict;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface DictMapper extends Mapper<Dict>{
    List<Dict> selectDictByField(Map map);
}
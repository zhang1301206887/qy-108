package com.aaa.zk.mapper;

import com.aaa.zk.model.Resource;
import com.aaa.zk.model.SpecialPost;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SpecialPostMapper extends Mapper<SpecialPost> {

    Integer selectSpecialPostCount(Object userId);

    List selectSpecialPostByUserId(Object userId);

    List<Resource> selectResourceById(Object id);
}
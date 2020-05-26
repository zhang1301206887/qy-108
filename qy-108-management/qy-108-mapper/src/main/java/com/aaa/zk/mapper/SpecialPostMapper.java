package com.aaa.zk.mapper;

import com.aaa.zk.model.SpecialPost;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecialPostMapper extends Mapper<SpecialPost> {

    Integer selectSpecialPostCount(Object userId);

    List<SpecialPost> selectSpecialPostByUserId(Object userId);
}
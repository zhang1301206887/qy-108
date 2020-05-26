package com.aaa.zk.mapper;

import com.aaa.zk.model.SpecialPost;
import tk.mybatis.mapper.common.Mapper;

public interface SpecialPostMapper extends Mapper<SpecialPost> {

    //根据user_id查询单位特岗人员数量
    Integer selectSpecialPostCount(Object userId);
}
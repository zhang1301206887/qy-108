package com.aaa.zk.mapper;

import com.aaa.zk.model.Principal;
import com.aaa.zk.model.Resource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface PrincipalMapper extends Mapper<Principal> {

    List selectPrinByUserId(Object userId);
    List<Resource> selectResourceById(Object prinId);
}
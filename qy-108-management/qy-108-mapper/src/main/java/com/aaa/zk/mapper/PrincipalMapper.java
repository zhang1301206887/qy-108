package com.aaa.zk.mapper;

import com.aaa.zk.model.Principal;
import tk.mybatis.mapper.common.Mapper;

public interface PrincipalMapper extends Mapper<Principal> {

    Principal selectPrinByUserId(Object userId);

}
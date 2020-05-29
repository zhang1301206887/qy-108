package com.aaa.zk.mapper;

import com.aaa.zk.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


/**
 * @Author zk
 * @Date 2020/5/17
 */

public interface UserMapper extends Mapper<User>{
    List<User> selectUserByField(Map map);
}

package com.aaa.zk.mapper;

import com.aaa.zk.model.ResultCommit;
import tk.mybatis.mapper.common.Mapper;

public interface ResultCommitMapper extends Mapper<ResultCommit> {


    //根据refId查询项目的汇交结果
    ResultCommit selectResultCommitByRefId(Object refId);
}
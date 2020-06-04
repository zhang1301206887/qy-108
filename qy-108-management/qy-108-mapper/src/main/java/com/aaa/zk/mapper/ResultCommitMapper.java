package com.aaa.zk.mapper;

import com.aaa.zk.model.ResultCommit;
import tk.mybatis.mapper.common.Mapper;

public interface ResultCommitMapper extends Mapper<ResultCommit> {
    ResultCommit selectResultCommitByRefId(Object refId);
}
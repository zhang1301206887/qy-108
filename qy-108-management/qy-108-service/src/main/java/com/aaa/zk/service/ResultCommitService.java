package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.ResultCommitMapper;
import com.aaa.zk.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zk
 * @Date 2020/5/29
 */
@Service
public class ResultCommitService extends BaseService<ResultCommit> {

    @Autowired
    private ResultCommitMapper resultCommitMapper;

    /**
    * @author zk
    * @Date
    *   根据 ref_id 查询项目的汇交结果
    */
    public ResultCommit selectResultCommitByRefId(Object refId){
        if (null != refId) {
            ResultCommit resultCommit = resultCommitMapper.selectResultCommitByRefId(refId);
            if (null != resultCommit){
                return resultCommit;
            }else {
                return null;
            }
        }
        return null;

    }
}

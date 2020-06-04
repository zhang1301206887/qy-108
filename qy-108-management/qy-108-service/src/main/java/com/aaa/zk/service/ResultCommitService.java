package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.ResultCommitMapper;
import com.aaa.zk.model.MappingProject;
import com.aaa.zk.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    *  新增汇交结果
    */
    public Integer resultCommitInsert(ResultCommit resultCommit){
        if (null != resultCommit){
            Integer i = resultCommitMapper.insertSelective(resultCommit);
            if (i > 0){
                return i;
            }
            return 0;
        }
        return 0;
    }


    /**
    * @author zk
    * @Date
    *   查询所有汇交结果
    */
    public List<ResultCommit> resultCommitSelectAll(){
        List<ResultCommit>  resultCommits = resultCommitMapper.selectAll();
        if (null != resultCommits && !"".equals(resultCommits)){
            return resultCommits;
        }
        return null;
    }
    /**
    * @author zk
    * @Date
    *   条件查询汇交结果
    */
    public List<ResultCommit> resultCommitSelect(ResultCommit resultCommit){
        if (resultCommit != null){
            // 不为空则 去添加到数据库
            List<ResultCommit> select = resultCommitMapper.select(resultCommit);
            // 判断查询到的数据是否为空
            if (null != select && !"".equals(select)){
                return select;
            }else {
                return null;
            }
        }else {
            // 为空则 直接返回null
            return null;
        }
    }

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

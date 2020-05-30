package com.aaa.zk.service;

import com.aaa.zk.model.ResultCommit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zk
 * @Date 2020/5/29
 */
@FeignClient(value = "resultCommit-interface")
public interface IQYResultCommitService {

    /**
     * @author zk
     * @Date
     *   根据refId查询项目汇交结果
     */
    @GetMapping("selectResultCommitByRefId/{refId}")
    ResultCommit selectResultCommitByRefId(@PathVariable("refId") Object refId);
}

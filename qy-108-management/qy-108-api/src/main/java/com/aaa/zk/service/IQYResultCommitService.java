package com.aaa.zk.service;

import com.aaa.zk.model.ResultCommit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author zk
 * @Date 2020/5/29
 */
@FeignClient(value = "resultCommit-interface")
public interface IQYResultCommitService {

    /**
     * @author zk
     * @Date
     *   新增项目汇交结果
     */
    @PostMapping("resultCommitInsert")
    Integer resultCommitInsert(@RequestBody ResultCommit resultCommit);

    /**
     * @author zk
     * @Date
     *   根据refId查询项目汇交结果
     */
    @GetMapping("selectResultCommitByRefId")
    ResultCommit selectResultCommitByRefId(@RequestParam("refId") Object refId);

    /**
     * @author zk
     * @Date
     *   查询所有 汇交结果
     */
    @GetMapping("resultCommitSelectAll")
    List<ResultCommit> resultCommitSelectAll();
    /**
     * @author zk
     * @Date
     *  条件查询 汇交结果
     */
    @PostMapping("resultCommitSelect")
    List<ResultCommit> resultCommitSelect(@RequestBody ResultCommit resultCommit);
}

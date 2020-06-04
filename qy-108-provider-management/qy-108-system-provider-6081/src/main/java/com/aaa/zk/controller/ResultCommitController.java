package com.aaa.zk.controller;


import com.aaa.zk.model.ResultCommit;
import com.aaa.zk.service.ResultCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zk
 * @Date 2020/5/29
 */
@RestController
public class ResultCommitController {

    @Autowired
    private ResultCommitService resultCommitService;
    /**
    * @author zk
    * @Date
    *   新增项目汇交结果
    */
    @PostMapping("resultCommitInsert")
    public Integer resultCommitInsert(@RequestBody ResultCommit resultCommit){
        return resultCommitService.resultCommitInsert(resultCommit);
    }

    /**
     * @author zk
     * @Date
     *  条件查询 汇交结果
     */
    @PostMapping("resultCommitSelect")
    List<ResultCommit> resultCommitSelect(@RequestBody ResultCommit resultCommit){
        return resultCommitService.resultCommitSelect(resultCommit);
    }

    /**
    * @author zk
    * @Date
    *   查询所有 汇交结果
    */
    @GetMapping("resultCommitSelectAll")
    public List<ResultCommit> resultCommitSelectAll(){
        return resultCommitService.resultCommitSelectAll();
    }

    /**
    * @author zk
    * @Date
    *   根据refId查询项目汇交结果
    */
    @GetMapping("selectResultCommitByRefId")
    public ResultCommit selectResultCommitByRefId(@RequestParam("refId") Object refId){
        ResultCommit resultCommit = resultCommitService.selectResultCommitByRefId(refId);
        if (null != resultCommit && !"".equals(resultCommit)){
            return resultCommit;
        }else{
            return null;
        }

    }
}

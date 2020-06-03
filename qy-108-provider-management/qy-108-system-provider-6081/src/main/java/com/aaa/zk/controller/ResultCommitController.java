package com.aaa.zk.controller;


import com.aaa.zk.model.ResultCommit;
import com.aaa.zk.service.ResultCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

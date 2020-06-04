package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.ResultCommit;
import com.aaa.zk.service.IQYResultCommitService;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zk
 * @Date 2020/5/29
 */
@RestController
@Api(value = "项目成果汇交" , tags = "项目成果汇交管理")
public class ResultCommitController extends BaseController {
    @Autowired
    private IQYResultCommitService iqyResultCommitService;

    /**
     * @author zk
     * @Date
     *   新增项目汇交结果
     */
    @PostMapping("resultCommitInsert")
    @ApiOperation(value = "新增功能",notes = "新增项目汇交结果")
    public ResultData resultCommitInsert(@RequestBody ResultCommit resultCommit){
        Integer i = iqyResultCommitService.resultCommitInsert(resultCommit);
        if (i > 0){
            return insertSuccess();
        }
        return insertFalied();
    }

    /**
     * @author zk
     * @Date
     *   根据refId查询项目汇交结果
     */
    @GetMapping("selectResultCommitByRefId")
    @ApiOperation(value = "查询功能",notes = "根据refId查询项目汇交结果")
    public ResultData selectResultCommitByRefId(@RequestParam("refId") Object refId){
        ResultCommit resultCommit = iqyResultCommitService.selectResultCommitByRefId(refId);
        if (null != resultCommit){
            return selelctSuccess(resultCommit);
        }else{
            return selelctFalied();
        }
    }
    /**
     * @author zk
     * @Date
     *   查询所有 汇交结果
     */
    @GetMapping("resultCommitSelectAll")
    @ApiOperation(value = "查询功能",notes = "查询所有项目汇交结果")
    public ResultData resultCommitSelectAll(){
        List<ResultCommit> resultCommits = iqyResultCommitService.resultCommitSelectAll();
        if (null != resultCommits && !"".equals(resultCommits)){
            return selelctSuccess(resultCommits);
        }
        return null;
    }
    /**
     * @author zk
     * @Date
     *   条件查询汇交结果
     */
    @GetMapping("resultCommitSelect")
    @ApiOperation(value = "查询功能",notes = "条件查询项目汇交结果")
    public ResultData resultCommitSelect(ResultCommit resultCommit){
        List<ResultCommit> resultCommits = iqyResultCommitService.resultCommitSelect(resultCommit);
        if (null != resultCommits && !"".equals(resultCommits)){
            return selelctSuccess(resultCommits);
        }
        return null;
    }

}

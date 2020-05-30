package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.ResultCommit;
import com.aaa.zk.service.IQYResultCommitService;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
     *   根据refId查询项目汇交结果
     */
    @GetMapping("selectResultCommitByRefId/{refId}")
    @ApiOperation(value = "查询功能",notes = "根据refId查询项目汇交结果")
    public ResultData selectResultCommitByRefId(@PathVariable("refId") Object refId){
        ResultCommit resultCommit = iqyResultCommitService.selectResultCommitByRefId(refId);
        if (null != resultCommit){
            return selelctSuccess(resultCommit);
        }else{
            return selelctFalied();
        }
    }

}

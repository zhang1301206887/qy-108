package com.aaa.zk.controller;

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Audit;
import com.aaa.zk.service.IQYAuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AuditController
 * @Author gfq
 * @Date 2020/5/26 22:04
 * @Version 1.0
 **/
@RestController
@Api(value = "项目审核", tags = "项目审核信息")
public class AuditController {
    @Autowired
    private IQYAuditService iqyAuditService;

    /**
     * @Author gfq
     * 项目审核中项目信息
     * @Date 16:21 2020/5/26
     **/
    @GetMapping("MProAuditSelectAll")
    @ApiOperation(value = "查询功能",notes = "查询所有的项目审核中项目数据")
    public ResultData MProAuditSelectAll(){
        return iqyAuditService.MProAuditSelectAll();
    }

    /**
     * @Author gfq
     * 项目审核-项目信息-根据项目id查询审核记录
     * 传  ref_id
     * @Date 20:58 2020/5/26
     **/
    @PostMapping("AuditSelect")
    @ApiOperation(value = "查询功能",notes = "根据项目id查询审核记录")
    public ResultData AuditSelect(@RequestBody Audit audit){
        return iqyAuditService.AuditSelect(audit);
    }

    /**
     * @Author gfq
     * 项目审核-项目审核-查询待审核的项目
     * @Date 21:00 2020/5/26
     **/
    @GetMapping("MPAuditSelect")
    @ApiOperation(value = "查询功能",notes = "查询待审核的项目")
    public ResultData MPAuditSelect(){
        return iqyAuditService.MPAuditSelect();
    }

    /**
     * @Author gfq
     * 项目审核-项目审核-查看审核项目详情
     * @Date 21:01 2020/5/26
     **/
    @GetMapping("MPAuditSelect2")
    @ApiOperation(value = "查询功能",notes = "查看审核项目详情")
    public ResultData MPAuditSelect2(){
        return iqyAuditService.MPAuditSelect2();
    }

    /**
     * @Author gfq
     * 项目审核-项目审核-审核项目 通过或不通过
     * 需要传 userid,status,submit_time时间,refid,create_time
     * @Date 21:02 2020/5/26
     **/
    @PostMapping("MPAuditAdd")
    @ApiOperation(value = "添加功能",notes = "审核项目 通过或不通过")
    public ResultData MPAuditAdd(@RequestBody Audit audit){
        return iqyAuditService.MPAuditAdd(audit);
    }
}

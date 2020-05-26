package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Audit;
import com.aaa.zk.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName AuditController
 * @Author gfq
 * @Date 2020/5/26 19:02
 * @Version 1.0
 **/
@RestController
public class AuditController  extends BaseController {

    @Autowired
    private AuditService auditService;

    /**
     * @Author gfq
     * 项目审核中项目信息
     * @Date 16:21 2020/5/26
     **/
    @GetMapping("MProAuditSelectAll")
    public ResultData MProAuditSelectAll(){
        List<HashMap> hashMaps = auditService.MProAuditSelectAll();
        if (null != hashMaps && !"".equals(hashMaps)){
            return selelctSuccess(hashMaps);
        }else {
            return selelctFalied();
        }
    }

    /**
     * @Author gfq
     * 项目审核-项目信息-根据项目id查询审核记录
     * 传  ref_id
     * @Date 20:58 2020/5/26
     **/
    @PostMapping("AuditSelect")
    public ResultData AuditSelect(@RequestBody Audit audit){
        List<Audit> audits = auditService.AuditSelect(audit);
        if (null != audits && !"".equals(audits)){
            return selelctSuccess(audits);
        }
        return selelctFalied();
    }

    /**
     * @Author gfq
     * 项目审核-项目审核-查询待审核的项目
     * @Date 21:00 2020/5/26
     **/
    @GetMapping("MPAuditSelect")
    public ResultData MPAuditSelect(){
        List<HashMap> hashMaps = auditService.MPAuditSelect();
        if (null != hashMaps && !"".equals(hashMaps)){
            return selelctSuccess(hashMaps);
        }else {
            return selelctFalied();
        }
    }

    /**
     * @Author gfq
     * 项目审核-项目审核-查看审核项目详情
     * @Date 21:01 2020/5/26
     **/
    @GetMapping("MPAuditSelect2")
    public ResultData MPAuditSelect2(){
        List<HashMap> hashMaps = auditService.MPAuditSelect2();
        if (null != hashMaps && !"".equals(hashMaps)){
            return selelctSuccess(hashMaps);
        }else {
            return selelctFalied();
        }
    }

    /**
     * @Author gfq
     * 项目审核-项目审核-审核项目 通过或不通过
     * 需要传 userid,status,submit_time时间,refid,create_time
     * @Date 21:02 2020/5/26
     **/
    @PostMapping("MPAuditAdd")
    public ResultData MPAuditAdd(@RequestBody Audit audit){
        Integer i = auditService.MPAuditAdd(audit);
        if (i>0){
            return insertSuccess();
        }else {
            return insertFalied();
        }
    }




}

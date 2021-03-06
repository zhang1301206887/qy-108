package com.aaa.zk.service;

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Audit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @ClassName AuditService
 * @Author gfq
 * @Date 2020/5/26 22:00
 * @Version 1.0
 **/
@FeignClient(value = "audit-interface")
public interface IQYAuditService {

    /**
     * @Author gfq
     * 项目审核中项目信息
     * @Date 16:21 2020/5/26
     **/
    @PostMapping("MProAuditSelectAll")
    ResultData MProAuditSelectAll(@RequestBody Map map);

    /**
     * @Author gfq
     * 项目审核-项目信息-根据项目id查询审核记录
     * 传  ref_id
     * @Date 20:58 2020/5/26
     **/
    @PostMapping("AuditSelect")
    ResultData AuditSelect(@RequestBody Audit audit);

    /**
     * @Author gfq
     * 项目审核-项目信息-根据项目名称查找项目
     * @Date 13:21 2020/6/1
     **/
    @PostMapping("likeMProAuditSelect")
    ResultData likeMProAuditSelect(@RequestBody Object projectName);

    /**
     * @Author gfq
     * 项目审核-项目审核-查询待审核的项目
     * @Date 21:00 2020/5/26
     **/
    @PostMapping("MPAuditSelect")
    ResultData MPAuditSelect(@RequestBody Map map);

    /**
     * @Author gfq
     * 项目审核-项目审核-根据项目名称查询待审核的项目
     * @Date 18:00 2020/5/26
     **/
    @PostMapping("likeMappingProAuditSelect")
    ResultData likeMappingProAuditSelect(@RequestBody Object projectName);

    /**
     * @Author gfq
     * 项目审核-项目审核-查看审核项目详情
     * @Date 21:01 2020/5/26
     **/
    @GetMapping("MPAuditSelect2")
    ResultData MPAuditSelect2();

    /**
     * @Author gfq
     * 项目审核-项目审核-审核项目 通过或不通过
     * 需要传 userid,status,submit_time时间,refid,create_time
     * @Date 21:02 2020/5/26
     **/
    @PostMapping("MPAuditAdd")
    ResultData MPAuditAdd(@RequestBody Audit audit);
    /**
    * @author zk
    * @Date
    *    添加项目成果汇交审核记录   传入audit
    */
    @PostMapping("MappingProjectResultAuditAdd")
    Integer MappingProjectResultAuditAdd(@RequestBody Audit audit);
}

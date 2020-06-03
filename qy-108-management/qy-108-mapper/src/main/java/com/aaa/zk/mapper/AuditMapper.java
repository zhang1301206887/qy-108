package com.aaa.zk.mapper;

import com.aaa.zk.model.Audit;
import com.aaa.zk.model.MappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface AuditMapper extends Mapper<Audit> {
       List<MappingProject> MProAuditSelectAll();
       List<HashMap> MPAuditSelect();
       List<HashMap> likeMProAuditSelect(Object projectName);
       List<HashMap> likeMappingProAuditSelect(Object projectName);

       /**
        * @Author gfq
        * 把待审核状态修改为已经审核过
        * @Date 22:19 2020/6/3
        **/
       Integer updateStatus(Long id);
}
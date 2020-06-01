package com.aaa.zk.mapper;

import com.aaa.zk.model.Audit;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface AuditMapper extends Mapper<Audit> {
       List<HashMap> MProAuditSelectAll();
       List<HashMap> MPAuditSelect();

}
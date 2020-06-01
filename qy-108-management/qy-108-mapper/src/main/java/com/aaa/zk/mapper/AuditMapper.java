package com.aaa.zk.mapper;

import com.aaa.zk.model.Audit;
import org.omg.CORBA.OBJ_ADAPTER;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface AuditMapper extends Mapper<Audit> {
       List<HashMap> MProAuditSelectAll();
       List<HashMap> MPAuditSelect();
       List<HashMap> likeMProAuditSelect(Object projectName);
       List<HashMap> likeMappingProAuditSelect(Object projectName);
}
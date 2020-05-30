package com.aaa.zk.service;

import com.aaa.zk.mapper.AuditMapper;
import com.aaa.zk.model.Audit;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;

import java.util.HashMap;
import java.util.List;

import static com.aaa.zk.staticstatus.AuditStatus.*;


/**
 * @ClassName AuditService
 * @Author gfq
 * @Date 2020/5/26 15:37
 * @Version 1.0
 **/
@Service
public class AuditService {
    @Autowired
    private AuditMapper auditMapper;


    /**
     * @Author gfq 
     * 项目审核中项目信息
     * @Date 16:21 2020/5/26
     **/
    public List<HashMap> MProAuditSelectAll(){
        List<HashMap> hashMaps = auditMapper.MProAuditSelectAll();
        if (null != hashMaps && !"".equals(hashMaps)){
            return hashMaps;
        }else {
            return null;
        }
    }

    /**
     * @Author gfq
     *  项目审核-项目信息-根据项目id查询审核记录
     * @Date 16:43 2020/5/26
     **/
     public List<Audit> AuditSelect(Audit audit){
         if (audit != null){
             audit.setType(TYPE);
             List<Audit> select = auditMapper.select(audit);
             if (null != select && !"".equals(select)){
                 return select;
             }else {
                 return null;
             }
         }
         return null;
     }

     /**
      * @Author gfq
      * 项目审核-项目审核-查询待审核的项目
      * @Date 18:00 2020/5/26
      **/
     public List<HashMap> MPAuditSelect(){
             List<HashMap> hashMaps = auditMapper.MPAuditSelect();
             if (null != hashMaps && !"".equals(hashMaps)){
                 return hashMaps;
             }else {
                 return null;
             }
     }

     /**
      * @Author gfq
      *  项目审核-项目审核-查看审核项目详情
      * @Date 18:49 2020/5/26
      **/
      public List<HashMap> MPAuditSelect2(){
          List<HashMap> hashMaps = MPAuditSelect();
          if (null != hashMaps && !"".equals(hashMaps)){
              return hashMaps;
          }else {
              return null;
          }
      }

      /**
       * @Author gfq
       * 项目审核-项目审核-审核项目 通过或不通过
       * @Date 18:53 2020/5/26
       **/
       public Integer MPAuditAdd(Audit audit){
           if (audit != null){
               audit.setAuditTime(DateUtils.getNowDate()).setName(NAME).setType(TYPE).setId(IDUtils.getID());
               int i = auditMapper.insert(audit);
               if (i>0){
                   return i;
               }else {
                   return null;
               }
           }
           return null;
       }
}

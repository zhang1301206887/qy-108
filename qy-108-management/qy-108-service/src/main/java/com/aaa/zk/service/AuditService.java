package com.aaa.zk.service;

import com.aaa.zk.mapper.AuditMapper;
import com.aaa.zk.model.Audit;
import com.aaa.zk.model.MappingProject;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 项目审核中查看所有项目信息
     * @Date 16:21 2020/5/26
     **/
    public PageInfo<MappingProject> MProAuditSelectAll(Map map){
        // 判断map是否为空
        if (map != null){
            //获取map中的分页页数
            Object pageNo = map.get("pageNo");
            //获取分页的页数多少
            Object pageSize = map.get("pageSize");
            //封装进pagehelper
            PageHelper.startPage(Integer.parseInt(pageNo.toString()),Integer.parseInt(pageSize.toString()));
            //调用auditMapper中的MProAuditSelectAll方法查询所有的项目信息
            List<MappingProject> hashMaps = auditMapper.MProAuditSelectAll();
            // 判断 hashMaps 是否为空
            if (null != hashMaps && !"".equals(hashMaps)){
                //将搜索的结果集 放入pageinfo返回
                PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo(hashMaps);
                // 不为空则直接返回
                return mappingProjectPageInfo;
            }
        }
        return null;

    }

    /**
     * @Author gfq
     *  项目审核-项目信息-根据项目id查询审核记录
     * @Date 16:43 2020/5/26
     **/
    public List<Audit> AuditSelect(Audit audit){
        // 判断前台 传的audit 是否为空
        if (audit != null){
            // 查询的是项目等级审核 需要传个type为2
            audit.setType(TYPE);
            // 调用通用mapper中的select方法根据id查询审核记录
            List<Audit> select = auditMapper.select(audit);
            // 判断select 是否为空
            if (null != select && !"".equals(select)){
                // 不为空直接返回
                return select;
            }else {
                return null;
            }
        }
        return null;
    }

    /**
     * @Author gfq
     * 项目审核-项目信息-根据项目名称搜索项目
     * @Date 13:03 2020/6/1
     **/
    public List<HashMap> likeMProAuditSelect(Object projectName){
        // 判断 projectName 是否为空
        if (projectName != null){
            // 不为空 调用auditMapper 中likeMProAuditSelect方法来搜索项目
            List<HashMap> hashMaps = auditMapper.likeMProAuditSelect(projectName);
            // 判断 hashMaps 是否为空
            if (hashMaps.size()>0 && !"".equals(hashMaps)){
                //不为空直接返回
                return hashMaps;
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
    public PageInfo<List> MPAuditSelect(Map map) {
        // 判断map是否为空
        if (map != null) {
            //获取map中的分页页数
            Object pageNo = map.get("pageNo");
            //获取分页的页数多少
            Object pageSize = map.get("pageSize");
            //封装进pagehelper
            PageHelper.startPage(Integer.parseInt(pageNo.toString()), Integer.parseInt(pageSize.toString()));
            //调用auditMapper 中MPAuditSelect方法来查询待审核的项目
            List<HashMap> hashMaps = auditMapper.MPAuditSelect();
            // 判断 hashMaps 是否为空
            if (null != hashMaps && !"".equals(hashMaps)) {
                PageInfo<List> pageInfo = new PageInfo(hashMaps);
                //不为空直接返回
                return pageInfo;
            }

        }
        return null;
    }

    /**
     * @Author gfq
     * 项目审核-项目审核-根据项目名称查询待审核的项目
     * @Date 18:00 2020/5/26
     **/
    public List<HashMap> likeMappingProAuditSelect(Object projectName){
        // 判断 projectName 是否为空
        if (projectName != null){
            // 不为空 调用auditMapper 中likeMappingProAuditSelect方法来搜索项目
            List<HashMap> hashMaps = auditMapper.likeMappingProAuditSelect(projectName);
            // 判断 hashMaps 是否为空
            if (hashMaps.size()>0 && !"".equals(hashMaps)){
                //不为空直接返回
                return hashMaps;
            }else {
                return null;
            }
        }
        return null;
    }

    /**
     * @Author gfq
     *  项目审核-项目审核-查看审核项目详情
     * @Date 18:49 2020/5/26
     **/
    public List<HashMap> MPAuditSelect2(){
        //调用本类中的MPAuditSelect方法来查看项目详情 因为MPAuditSelect方法也是查询了项目的所有信息
        List<HashMap> hashMaps = auditMapper.MPAuditSelect();
        // 判断 hashMaps 是否为空
        if (null != hashMaps && !"".equals(hashMaps)){
            //不为空直接返回
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
        //判断audit是否为空
        if (audit != null){
            // 把待审核状态修改为已经审核过
            Integer integer = auditMapper.updateStatus(audit.getId());
            // 向audit里添加固定的数据
            audit.setAuditTime(DateUtils.getNowDate()).setName(NAME).setType(TYPE).setId(IDUtils.getID());
            // 添加数据
            int i = auditMapper.insertSelective(audit);
            //
            if (i>0 && integer>0){
                return i;
            }else {
                return null;
            }
        }
        return null;
    }
       /**
       * @author zk
       * @Date
       *    添加项目成果汇交审核记录   传入audit
       */
        public Integer MappingProjectResultAuditAdd(Audit audit) {
            if (audit != null){
                audit.setAuditTime(DateUtils.getNowDate()).setName(SUBMIT_NAME).setType(SUBMIT_TYPE).setId(IDUtils.getID());
                int i = auditMapper.insertSelective(audit);
                if (i > 0 ){
                    return i;
                }else {
                    return 0;
                }

            }
            return 0;
        }
}

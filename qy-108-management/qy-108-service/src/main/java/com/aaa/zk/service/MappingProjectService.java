package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.AuditMapper;
import com.aaa.zk.mapper.MappingProjectMapper;
import com.aaa.zk.model.Audit;
import com.aaa.zk.model.MappingProject;
import com.aaa.zk.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

import static com.aaa.zk.staticstatus.AuditStatus.*;

@Service
public class MappingProjectService extends BaseService<MappingProject> {

    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    @Autowired
    private AuditMapper auditMapper;

    //使用工具类 获取当前时间并转化格式
    private String nowDate = new DateUtil().getNowDate();

    /**
     * 生成随机数
     */
    private Long number = Math.round(1000000*Math.random());
    /**
     * @author zk
     * @Date
     *   根据user_id查询公司项目数量
     */
    public Integer selectProjectCountByUserId(@RequestBody Object userId){

        if (null !=userId){
            Integer i = mappingProjectMapper.selectProjectCountByUserId(userId);
            if (i > 0){
                return i;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }



    /**
    * @author zk
    * @Date
    *查询测绘不同类别及是否完成的数量，用于统计图
    */
    public List<Map> selectProjectType(){
        List<Map> mapList = mappingProjectMapper.selectProjectType();
        //判断结果是否为空
        if (mapList!=null && !mapList.isEmpty()){
            //不为空 返回数据
            return mapList;
        }else{
            //查询失败 返回null
            return null;
        }
    }



    /**
     * @author: gfq
     * 查询所有项目管理
     * @date: 20-05-25 13:29
     */
    public List<MappingProject> MappingProjectSelectAll(){
        List<MappingProject> mappingProjects = mappingProjectMapper.selectAll();
        if (null != mappingProjects && !"".equals(mappingProjects)){
            return mappingProjects;
        }else {
            return null;
        }
    }

    /**
     * @author: gfq
     * 新增项目管理
     * @date: 20-05-25 13:37
     */
    public Integer MappingProjectAdd(MappingProject mappingProject){
        Audit audit = new Audit();
        // 先判断传过来的MappingProject实体是否为空
        if (mappingProject != null){
            mappingProject.setStartDate(nowDate);
            // 不为空则 去添加到数据库
            int i = mappingProjectMapper.insert(mappingProject);
            audit.setId(number).setType(TYPE).setName(NAME).setStatus(STATUS).setUserId(mappingProject.getUserId()).setCreateTime(nowDate).setRefId(mappingProject.getId()).setSubmitTime(nowDate);
            int i1 = auditMapper.insert(audit);
            // 判断 i返回受影响的行数是否大于0
            if (i>0 && i1>0){
                return i;
            }else {
                return null;
            }
        }else {
            // 为空则 直接返回null
            return null;
        }
    }

    /**
     * @author: gfq
     * 按条件查询数据
     * @date: 20-05-25 13:42
     */
    public List<MappingProject> MappingProjectSelect(MappingProject mappingProject){
        // 先判断传过来的MappingProject实体是否为空
        if (mappingProject != null){
            // 不为空则 去添加到数据库
            List<MappingProject> select = mappingProjectMapper.select(mappingProject);
            // 判断查询到的数据是否为空
            if (null != select && !"".equals(select)){
                return select;
            }else {
                return null;
            }
        }else {
            // 为空则 直接返回null
            return null;
        }
    }

    /**
     * @author: gfq
     *  修改项目信息
     * @date: 20-05-25 13:50
     */
    public Integer MappingProjectUpdate(MappingProject mappingProject){
        // 先判断传过来的MappingProject实体是否为空
        if (mappingProject != null){
            // 不为空则 去添加到数据库
            int i = mappingProjectMapper.updateByPrimaryKeySelective(mappingProject);
            // 判断 i返回受影响的行数是否大于0
            if (i>0){
                return i;
            }else {
                return null;
            }
        }else {
            // 为空则 直接返回null
            return null;
        }
    }

    /**
     * @author: gfq
     *  根据id 删除项目
     * @date: 20-05-25 13:53
     */
    public Integer MappingProjectDelete(Object id){
        int i = mappingProjectMapper.deleteByPrimaryKey(id);
        // 判断 i返回受影响的行数是否大于0
        if (i>0){
            return i;
        }else {
            return null;
        }
    }

}

package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/24 21:21
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.TechnicistMapper;
import com.aaa.zk.model.Technicist;
import com.aaa.zk.utils.DateUtil;
import com.aaa.zk.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aaa.zk.status.CURDStatus.CRUD_FALIED;

@Service
public class TechnicistService extends BaseService<Technicist> {

    @Autowired
    private TechnicistMapper technicistMapper;

    /**
    * @Author: He create on 2020/5/24 23:12
    * @param: []
    * @return: java.util.List<com.aaa.zk.model.Technicist>
    * @Description: 查询所有的激素人员
    */
    public List<Technicist> selectAllTech(){
        List<Technicist> technicists = technicistMapper.selectAll();
        if (null != technicists && technicists.size() > 0){
            return technicists;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/24 23:35
    * @param: [userId]
    * @return: java.util.List<com.aaa.zk.model.Technicist>
    * @Description: 根据公司id查询技术人员信息
    */
    public List<Technicist> selectTechByUserId(Object userId){
        List<Technicist> technicists = technicistMapper.selectTechByUserId(userId);
        if (null != technicists && technicists.size() > 0){
            return technicists;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/24 23:12
    * @param: [technicist]
    * @return: com.aaa.zk.model.Technicist
    * @Description: 根据主键id查询技术人员信息
    */
    public Technicist selectTechByPrimaryKey (Object id){
        if (null != id){
            Technicist selectByPrimaryKey = technicistMapper.selectByPrimaryKey(id);
            if (null != selectByPrimaryKey && "".equals(selectByPrimaryKey)){
                return selectByPrimaryKey;
            }
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/24 23:12
    * @param: [technicist]
    * @return: java.lang.Integer
    * @Description: 添加新的技术人员信息
    */
    public Integer insertTech(Technicist technicist){
        if (null != technicist){
            technicist.setId(IDUtils.getID());
            technicist.setCreateTime(new DateUtil().getNowDate());
            int insert = technicistMapper.insert(technicist);
            if (insert > 0){
                return insert;
            }
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/24 23:13
    * @param: [technicist]
    * @return: java.lang.Integer
    * @Description: 根据主键id修改技术人员信息
    */
    public Integer updateTechByPrimaryKey(Technicist technicist){
        if (null != technicist){
            technicist.setModifyTime(new DateUtil().getNowDate());
            int update = technicistMapper.updateByPrimaryKey(technicist);
            if (update > 0){
                return update;
            }
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/24 23:14
    * @param: [technicist]
    * @return: java.lang.Integer
    * @Description: 根据主键删除技术人员信息
    */
    public Integer deleteTechByPrimaryKey(Object id){
        if (null != id){
            int delete = technicistMapper.deleteByPrimaryKey(id);
            if (delete > 0){
                return delete;
            }
        }
        return CRUD_FALIED;
    }
}

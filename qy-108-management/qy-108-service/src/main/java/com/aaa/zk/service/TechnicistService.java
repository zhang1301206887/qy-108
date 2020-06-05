package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/24 21:21
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.TechnicistMapper;
import com.aaa.zk.model.Resource;
import com.aaa.zk.model.Technicist;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public PageInfo<Map> selectTechByUserId(Object userId,Integer pageNo,Integer pageSize){
        if (null != userId && !"".equals(userId)){
            PageHelper.startPage(pageNo,pageSize);
            List<Map> technicists = technicistMapper.selectTechByUserId(userId);
            if (null != technicists && technicists.size() > 0){
                PageInfo<Map> pageInfo = new PageInfo<Map>(technicists);
                return pageInfo;
            }
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/24 23:12
    * @param: [technicist]
    * @return: com.aaa.zk.model.Technicist
    * @Description: 根据主键id查询技术人员信息和对应的附件信息
    */
    public Map selectTechByPrimaryKey (Object id){
        if (null != id){
            Map map = new HashMap();
            Technicist selectByPrimaryKey = technicistMapper.selectByPrimaryKey(id);
            List<Resource> resources = technicistMapper.selectResourceById(id);
            if (null != selectByPrimaryKey ){
                map.put("technicist",selectByPrimaryKey);
                if (null != resources && resources.size() > 0){
                    map.put("resource",resources);
                    return map;
                }
                return map;
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
            technicist.setCreateTime(DateUtils.getCurrentDate());
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
            technicist.setModifyTime(DateUtils.getCurrentDate());
            int update = technicistMapper.updateByPrimaryKeySelective(technicist);
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

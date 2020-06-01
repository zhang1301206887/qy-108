package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/26 10:59
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.PrincipalMapper;
import com.aaa.zk.model.Principal;
import com.aaa.zk.model.Resource;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.IDUtils;
import com.aaa.zk.utils.Map2BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.zk.status.CURDStatus.*;

@Service
public class PrincipaService extends BaseService<Principal> {

    @Autowired
    private PrincipalMapper principalMapper;

    /**
    * @Author: He create on 2020/5/26 11:37
    * @param: [userId]
    * @return: com.aaa.zk.model.Principal
    * @Description: 根据公司id查询负责人
    */
    public Map selectPrinByUserId(Object userId){
        if (null != userId){
            Map map = principalMapper.selectPrinByUserId(userId);
            if (null != map){
                return map;
            }
            return null;
        }
        return null;
    }

    /**
    * @Author: He create on 2020/5/26 11:37
    * @param: [prinId]
    * @return: com.aaa.zk.model.Principal
    * @Description: 根据主键id查询负责人和对应的附件信息
    */
    public Map selectPrinByPrimaryKey(Object prinId){
        if (null != prinId){
            Map map = new HashMap();
            //查询复制人的信息
            Principal principal = principalMapper.selectByPrimaryKey(prinId);
            //查询负责人的附件信息
            List<Resource> maps = principalMapper.selectResourceById(prinId);
            if (null != principal ){
                map.put("principal",principal);
                //如果没有附件信息 则直接返回人员信息
                if (null != maps && maps.size() > 0){
                    map.put("resource",maps);
                    return map;
                }
                return map;
            }
            return null;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/26 11:38
    * @param: [principal]
    * @return: java.lang.Integer
    * @Description: 根据主键id更新负责人信息
    */
    public Integer updatePrinByPrimaryKey(Principal principal){
        if (null != principal){
            principal.setModifyTime(DateUtils.getCurrentDate());
            int update = principalMapper.updateByPrimaryKey(principal);
            if (update > 0){
                return update;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/26 11:38
    * @param: [principal]
    * @return: java.lang.Integer
    * @Description: 添加新负责人信息
    */
    public Integer insertPrin(Principal principal){
        if (null != principal){
            principal.setId(IDUtils.getID());
            principal.setCreateTime(DateUtils.getCurrentDate());
            int insert = principalMapper.insert(principal);
            if (insert > 0){
                return insert;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/26 11:38
    * @param: [prinId]
    * @return: java.lang.Integer
    * @Description: 根据主键id删除负责人信息
    */
    public Integer deletePrinByPrimaryKey(Object prinId){
        if (null != prinId){
            int delete = principalMapper.deleteByPrimaryKey(prinId);
            if (delete > 0){
                return delete;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
}

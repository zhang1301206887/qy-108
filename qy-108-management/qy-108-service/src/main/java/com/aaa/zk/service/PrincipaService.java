package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/26 10:59
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.PrincipalMapper;
import com.aaa.zk.model.Principal;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Principal selectPrinByUserId(Object userId){
        if (null != userId){
            Principal principal = principalMapper.selectPrinByUserId(userId);
            if (null != principal){
                return principal;
            }
            return null;
        }
        return null;
    }

    /**
    * @Author: He create on 2020/5/26 11:37
    * @param: [prinId]
    * @return: com.aaa.zk.model.Principal
    * @Description: 根据主键id查询负责人
    */
    public Principal selectPrinByPrimaryKey(Object prinId){
        if (null != prinId){
            Principal principal = principalMapper.selectByPrimaryKey(prinId);
            if (null != principal ){
                return principal;
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

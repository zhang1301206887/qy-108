package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.SpecialPostMapper;
import com.aaa.zk.model.SpecialPost;
import com.aaa.zk.utils.DateUtil;
import com.aaa.zk.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.aaa.zk.status.CURDStatus.*;

import java.util.List;

/**
 * @Author zk
 * @Date 2020/5/25
 */
@Service
public class SpecialPostService extends BaseService<SpecialPost> {

    @Autowired
    private SpecialPostMapper specialPostMapper;


    /**
    * @author zk
    * @Date
    *   根据user_id查询公司特岗人员数量
    */
    public Integer selectSpecialPostCount(Object userId){
        if (null != userId){
            Integer i = specialPostMapper.selectSpecialPostCount(userId);
            if (i > 0){
                return i;
            }else{
                return CRUD_FALIED;
            }
        }else{
            return CRUD_FALIED;
        }
    }
    /**
    * @Author: He create on 2020/5/26 22:07
    * @param: [userId]
    * @return: java.util.List<com.aaa.zk.model.SpecialPost>
    * @Description: 根据公司id查询特殊岗位人员信息
    */
    public List<SpecialPost> selectSpecialPostByUserId(Object userId){
        if (null != userId){
            List<SpecialPost> specialPosts = specialPostMapper.selectSpecialPostByUserId(userId);
            if (null != specialPosts && specialPosts.size() > 0){
                return specialPosts;
            }
            return null;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/26 22:08
    * @param: [id]
    * @return: com.aaa.zk.model.SpecialPost
    * @Description: 根据主键id查询特殊岗位人员信息
    */
    public SpecialPost selectSpecialByPrimaryKey(Object id){
        if (null != id){
            SpecialPost specialPost = specialPostMapper.selectByPrimaryKey(id);
            if (null != specialPost){
                return specialPost;
            }
            return null;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/26 22:08
    * @param: [specialPost]
    * @return: java.lang.Integer
    * @Description: 添加特殊岗位人员信息
    */
    public Integer insertSpecial(SpecialPost specialPost){
        if (null != specialPost){
            specialPost.setCreateTime(new DateUtil().getNowDate());
            specialPost.setId(IDUtils.getID());
            int insert = specialPostMapper.insert(specialPost);
            if (insert > 0){
                return insert;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/26 22:08
    * @param: [specialPost]
    * @return: java.lang.Integer
    * @Description: 根据主键id更新特殊岗位人员信息
    */
    public Integer updateSpecialByPrimaryKey(SpecialPost specialPost){
        if (null != specialPost){
            specialPost.setModifyTime(new DateUtil().getNowDate());
            int update = specialPostMapper.updateByPrimaryKey(specialPost);
            if (update > 0){
                return update;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/26 22:08
    * @param: [id]
    * @return: java.lang.Integer
    * @Description: 根据主键id删除特殊岗位人员信息
    */
    public Integer deleteSpecialByPrimaryKey(Object id){
        if (null != id){
            int delete = specialPostMapper.deleteByPrimaryKey(id);
            if (delete > 0){
                return delete;
            }
            return  CRUD_FALIED;
        }
        return  CRUD_FALIED;
    }
}

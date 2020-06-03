package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.ResourceMapper;
import com.aaa.zk.model.Resource;
import static com.aaa.zk.status.CURDStatus.*;

import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author zk
 * @Date 2020/5/29
 */
@Service
public class ResourceService extends BaseService<Resource> {
    @Autowired
    private ResourceMapper resourceMapper;

    /**
    * @author zk
    * @Date
    *   根据 项目id查询 附件材料
    */
    public List<Resource> selectResourceByRefBizId(Object id){
        if (null != id) {
            List<Resource> list =  resourceMapper.selectResourceByRefBizId(id);
            if (list!=null && !list.isEmpty()){
                return list;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    /**
    * @Author: He create on 2020/6/3 20:11
    * @param: [resource]
    * @return: java.lang.Integer
    * @Description: 添加新的附件信息
    */
    public Integer insertResource(Resource resource){
        if (null != resource){
            int insert = resourceMapper.insert(resource.setId(IDUtils.getID()).setCreateTime(DateUtils.getCurrentDate()));
            if (insert > 0){
                return insert;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/6/3 20:07
    * @param: [map]
    * @return: com.aaa.zk.model.Resource
    * @Description: 根据id和类型查询对应的附件信息
    */
    public Resource selectResourceByIdAndType(Map map){
        if (null != map){
            Resource resource = resourceMapper.selectResourceByIdAndType(map);
            if (null != resource){
                return resource;
            }
            return null;
        }
        return null;
    }
}

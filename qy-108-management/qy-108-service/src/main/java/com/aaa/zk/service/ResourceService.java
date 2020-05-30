package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.ResourceMapper;
import com.aaa.zk.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

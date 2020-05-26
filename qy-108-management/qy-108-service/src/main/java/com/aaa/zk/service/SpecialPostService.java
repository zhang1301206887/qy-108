package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.SpecialPostMapper;
import com.aaa.zk.model.SpecialPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (null !=userId){
            Integer i = specialPostMapper.selectSpecialPostCount(userId);
            if (i > 0){
                return i;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

}

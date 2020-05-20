package com.aaa.zk.service;
/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/20 21:17
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.DictMapper;
import com.aaa.zk.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DictService extends BaseService<Dict> {

    @Autowired
    private DictMapper dictMapper;

    /**
    * @Author: He create on 2020/5/20 21:24
    * @param: []
    * @return: java.util.List<com.aaa.zk.model.Dict>
    * @Description: 查询字典表所有信息
    */
    public List<Dict> selectAll(){
        List<Dict> dicts = dictMapper.selectAll();
        if (null != dicts && dicts.size() > 0){
            return dicts;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/20 21:23
    * @param: [dict]
    * @return: java.util.List<com.aaa.zk.model.Dict>
    * @Description: 查询字典表
    */
    public List<Dict> selectByFiled(Dict dict){
        List<Dict> select = dictMapper.select(dict);
        if (null != select && select.size() > 0){
            return select;
        }
        return null;
    }

    /**
    * @Author: He create on 2020/5/20 21:25
    * @param: [dict]
    * @return: java.lang.Integer
    * @Description: 添加数据
    */
    public Integer insert(Dict dict){
        int insertResult = dictMapper.insert(dict);
        if (insertResult > 0 ){
            return insertResult;
        }
        return 0;
    }
    /**
    * @Author: He create on 2020/5/20 21:26
    * @param: [dict]
    * @return: java.lang.Integer
    * @Description: 根据主键id  更新数据
    */
    public Integer updateByPrimaryKey(Dict dict){
        int updateResult = dictMapper.updateByPrimaryKey(dict);
        if (updateResult > 0 ){
            return updateResult;
        }
        return 0;
    }
    /**
    * @Author: He create on 2020/5/20 21:27
    * @param: [id]
    * @return: java.lang.Integer
    * @Description: 根据主键id删除 数据
    */
    public Integer delectByPrimaryKey(Dict dict){
        int deleteResult = dictMapper.deleteByPrimaryKey(dict);
        if (deleteResult > 0 ){
            return deleteResult;
        }
        return 0;
    }
}

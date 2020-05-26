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
import java.util.Map;

import static com.aaa.zk.status.CURDStatus.CRUD_FALIED;

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
    public List<Dict> selectAllDict(){
        List<Dict> dicts = dictMapper.selectAll();
        if (null != dicts && dicts.size() > 0){
            return dicts;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/26 14:31
    * @param: [id]
    * @return: com.aaa.zk.model.Dict
    * @Description: 根据主键id查询字典表数据
    */
    public Dict selectDictByPrimaryKey(Object id){
        if (null != id){
            Dict dict = dictMapper.selectByPrimaryKey(id);
            if (null != dict){
                return dict;
            }
            return null;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/20 21:23
    * @param: [dict]
    * @return: java.util.List<com.aaa.zk.model.Dict>
    * @Description: 条件查询字典表
    */
    public List<Dict> selectDictByFiled(Dict dict){
        if (null != dict){
            List<Dict> select = dictMapper.select(dict);
            if (null != select && select.size() > 0){
                return select;
            }
        }
        return null;
    }

    /**
    * @Author: He create on 2020/5/20 21:25
    * @param: [dict]
    * @return: java.lang.Integer
    * @Description: 添加数据
    */
    public Integer insertDict(Dict dict){
        if (null != dict){
            int insertResult = dictMapper.insert(dict);
            if (insertResult > 0 ){
                return insertResult;
            }
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/20 21:26
    * @param: [dict]
    * @return: java.lang.Integer
    * @Description: 根据主键id  更新数据
    */
    public Integer updateDictByPrimaryKey(Dict dict){
        if (null != dict){
            int updateResult = dictMapper.updateByPrimaryKey(dict);
            if (updateResult > 0 ){
                return updateResult;
            }
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/20 21:27
    * @param: [id]
    * @return: java.lang.Integer
    * @Description: 根据主键id删除 数据
    */
    public Integer delectDictByPrimaryKey(Object id){
        if (null != id){
            int deleteResult = dictMapper.deleteByPrimaryKey(id);
            if (deleteResult > 0 ){
                return deleteResult;
            }
        }
        return CRUD_FALIED;
    }
    /**
     * @Author: He create on 2020/5/21 23:07
     * @param: [map]
     * @return: java.lang.Integer
     * @Description: 通过主键id批量删除数据
     */
    public Integer deleteDictByPrimaryKeyList(List<Map> list){
        Integer deleteNum = 0;
        //循环遍历list中的map 取出其中的id进行删除操作
        for (Map map : list){
            Object id = map.get("id");
            int deleteResult = dictMapper.deleteByPrimaryKey(id);
            if (deleteResult > 0){
                deleteNum += 1;
            }
        }
        return deleteNum;
    }
}

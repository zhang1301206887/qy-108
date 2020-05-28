package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.MappingUnitMapper;
import com.aaa.zk.model.MappingUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.aaa.zk.status.CURDStatus.CRUD_FALIED;

/**
 * @Author zk
 * @Date 2020/5/22
 */
@Service
public class MappingUnitService extends BaseService<MappingUnit> {

    @Autowired
    private MappingUnitMapper mappingUnitMapper;

    /**
     * 查询单位资质的类别及各自的数量
     * */
    public List<Map> selectCountLevel(){
        //查询单位资质及数量
        List<Map> mapList = mappingUnitMapper.selectCountLevel();
        //判断查到的数据是否为空
        if (mapList!=null && !mapList.isEmpty()){
            //不为空
            return mapList;
        }else{
            //查询失败
            return null;
        }
    }
    /**
    * @author zk
    * @Date
    *    查询所有单位基本信息
    */
    public List<MappingUnit> selectAllUnit(){
         List<MappingUnit> mappingUnitList = mappingUnitMapper.selectAll();
         if (mappingUnitList!=null && !mappingUnitList.isEmpty()){
             return mappingUnitList;
         }else{
             return null;
         }
    }
    /**
    * @Author: He create on 2020/5/28 19:32
    * @param: [mappingUnit]
    * @return: java.lang.Integer
    * @Description: 根据主键id进行加分操作
    */
    public Integer updateInsertScoreById(MappingUnit mappingUnit){
        if (null != mappingUnit){
            Integer integer = mappingUnitMapper.updateInsertScoreById(mappingUnit);
            if (integer > 0){
                return integer;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/28 19:34
    * @param: [mappingUnit]
    * @return: java.lang.Integer
    * @Description: 根据主键id进行减分操作
    */
    public Integer updateDeleteScoreById(MappingUnit mappingUnit){
        if (null != mappingUnit){
            Integer integer = mappingUnitMapper.updateDeleteScoreById(mappingUnit);
            if (integer > 0){
                return integer;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }

}

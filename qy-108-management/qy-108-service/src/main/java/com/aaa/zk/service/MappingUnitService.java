package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.MappingProjectMapper;
import com.aaa.zk.mapper.MappingUnitMapper;
import com.aaa.zk.mapper.SpecialPostMapper;
import com.aaa.zk.mapper.TechnicistMapper;
import com.aaa.zk.model.MappingUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    @Autowired
    private MappingProjectMapper mappingProjectMapper;
    @Autowired
    private SpecialPostMapper specialPostMapper;
    @Autowired
    private TechnicistMapper technicistMapper;
    /**
     * @author zk
     * @Date
     *   根据单位id
     *   查询 单位人员和项目数量
     */
    public List<Map> selectPeopleProjectCountByUnitId(Object userId){
        if (null != userId){
            //查询技术人员数量
            List<Map> list = technicistMapper.selectTechCountByUserId(userId);
            //查询项目数量
            Integer i = mappingProjectMapper.selectProjectCountByUserId(userId);
            //把项目数量放到map中
            Map map1 = new HashMap();
            map1.put("type","项目数量");
            map1.put("count",i);
            //将map1对象添加到list中
            list.add(map1);
            //查询特岗员工数量
            i = specialPostMapper.selectSpecialPostCount(userId);
            //把特岗工人数放到map中
            Map map2 = new HashMap();
            map2.put("type","特岗人员");
            map2.put("count",i);
            //将map2对象添加到list中
            list.add(map2);
            return list;
        }
        return null;
    }


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
    * @Author: He create on 2020/5/28 21:22
    * @param: [map]
    * @return: java.util.List<com.aaa.zk.model.MappingUnit>
    * @Description: 条件查询sql拼接
    */
    public List<MappingUnit> selectUnitByField(Map map){
        if (null != map){
            List<MappingUnit> mappingUnits = mappingUnitMapper.selectUnitByField(map);
            if (null != mappingUnits && mappingUnits.size() > 0){
                return mappingUnits;
            }
            return null;
        }
        return null;
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

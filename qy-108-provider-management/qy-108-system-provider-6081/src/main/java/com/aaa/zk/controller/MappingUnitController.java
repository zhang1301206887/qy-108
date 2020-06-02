package com.aaa.zk.controller;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.CommonController;
import com.aaa.zk.base.ResultData;

import com.aaa.zk.model.MappingUnit;
import com.aaa.zk.service.MappingUnitService;
import com.aaa.zk.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author zk
 * @Date 2020/5/22
 */
@RestController
public class MappingUnitController extends CommonController<MappingUnit> {

    @Autowired
    private MappingUnitService mappingUnitService;

    public BaseService<MappingUnit> getBaseService() {
        return mappingUnitService;
    }

    /**
    * @author zk
    * @Date
    *   根据单位id查询 单位人员 和项目情况
    */
    @GetMapping("/selectPeopleProjectCountByUnitId")
    public List<Map> selectPeopleProjectCountByUnitId(@RequestParam("userId") Integer userId){
        return mappingUnitService.selectPeopleProjectCountByUnit(userId);
    }


    /**
     * 查询单位资质等级及数量
     * */
    @GetMapping("/selectCountLevel")
    public ResultData selectCountLevel(){
        List<Map> maps = mappingUnitService.selectCountLevel();
        if (null != maps){
            return selelctSuccess(maps);
        }
        return selelctFalied();
    }
    /**
    * @author zk
    * @Date
    *查询所有单位基本信息
    */
    @GetMapping("/selectAllUnit")
    public ResultData selectAllUnit(){
        List<MappingUnit> mappingUnits = mappingUnitService.selectAllUnit();
        if (null != mappingUnits){
            return selelctSuccess(mappingUnits);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/28 21:24
    * @param: [map]
    * @return: com.aaa.zk.base.ResultData
    * @Description: sql拼接的 多条件查询
    */
    @PostMapping("selectUnitByField")
    public ResultData selectUnitByField(@RequestBody Map map){
        List<MappingUnit> mappingUnits = mappingUnitService.selectUnitByField(map);
        if (null != mappingUnits){
            return selelctSuccess(mappingUnits);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/28 20:44
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据id查询单位信息
    */
    @GetMapping("selectOneUnit")
    public ResultData selectOneUnit(@RequestParam("id") Object id){
        try {
            MappingUnit mappingUnit = (MappingUnit) new MappingUnit().setId(Long.valueOf(id.toString()));
            MappingUnit mappingUnit1 = mappingUnitService.queryOne(mappingUnit);
            if ("".equals(mappingUnit1) && null != mappingUnit1){
                return selelctSuccess(mappingUnit1);
            }
            return selelctFalied();
        }catch (Exception e){
            e.printStackTrace();
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/28 20:44
    * @param: [mappingUnit]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键进行单位信息的修改
    */
    @PostMapping("updateUnit")
    public ResultData updateUnit(@RequestBody MappingUnit mappingUnit){
        try {
            mappingUnit.setAuditStatus(2).setModifyTime(DateUtils.getCurrentDate());
            Integer update = mappingUnitService.update(mappingUnit);
            if (update > 0){
                return updataSuccess();
            }
            return updateFalied();
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateFalied();
    }
}

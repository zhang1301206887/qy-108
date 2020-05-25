package com.aaa.zk.controller;

import com.aaa.zk.model.MappingUnit;
import com.aaa.zk.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author zk
 * @Date 2020/5/22
 */
@RestController
public class MappingUnitController {

    @Autowired
    private MappingUnitService mappingUnitService;
    /**
     * 查询单位资质等级及数量
     * */
    @GetMapping("/selectCountLevel")
    public List<Map> selectCountLevel(){
        return mappingUnitService.selectCountLevel();

    }
    /**
    * @author zk
    * @Date
    *查询所有单位基本信息
    */
    @GetMapping("/selectAllUnit")
    public List<MappingUnit> selectAllUnit(){
        return mappingUnitService.selectAllUnit();
    }

}

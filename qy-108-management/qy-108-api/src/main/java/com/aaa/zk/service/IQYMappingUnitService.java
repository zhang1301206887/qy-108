package com.aaa.zk.service;

import com.aaa.zk.model.MappingUnit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @Author zk
 * @Date 2020/5/22
 */
@FeignClient(value = "mappingUnit-interface")
public interface IQYMappingUnitService {

    /**
     * 查询单位资质等级及数量，用于统计图
     **/
    @GetMapping("/selectCountLevel")
    List<Map> selectCountLevel();
    /**
    * @author zk
    * @Date
    * 查询所有单位本信息
    */
    @GetMapping("/selectAllUnit")
    List<MappingUnit> selectAllUnit();
}

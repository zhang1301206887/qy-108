package com.aaa.zk.service;

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingUnit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResultData selectCountLevel();
    /**
    * @author zk
    * @Date
    * 查询所有单位本信息
    */
    @GetMapping("/selectAllUnit")
    public ResultData selectAllUnit();

    /**
     * @Author: He create on 2020/5/28 21:24
     * @param: [map]
     * @return: com.aaa.zk.base.ResultData
     * @Description: sql拼接的 多条件查询
     */
    @PostMapping("selectUnitByField")
    public ResultData selectUnitByField(@RequestBody Map map);
    /**
     * @Author: He create on 2020/5/28 20:44
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据id查询单位信息
     */
    @GetMapping("selectOneUnit/{id}")
    public ResultData selectOneUnit(@PathVariable("id") Object id);
    /**
     * @Author: He create on 2020/5/28 20:44
     * @param: [mappingUnit]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键进行单位信息的修改
     */
    @PostMapping("updateUnit")
    public ResultData updateUnit(@RequestBody MappingUnit mappingUnit);
}

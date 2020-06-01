package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/24 23:40
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Technicist;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@FeignClient(value = "tech-interface")
public interface IQYTechService {

    /**
     * @Author: He create on 2020/5/24 23:39
     * @param: []
     * @return: com.aaa.zk.base.ResultData
     * @Description: 查询所有的技术人员信息
     */
    @GetMapping("selectAllTech")
    public ResultData selectAllTech();

    /**
     * @Author: He create on 2020/5/24 23:39
     * @param: [map]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据公司id查询技术人员信息
     */
    @GetMapping("selectTechByUserId")
    public ResultData selectTechByUserId(@RequestParam("userId") Object userId);

    /**
     * @Author: He create on 2020/5/24 23:39
     * @param: [technicist]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id查询技术人员信息
     */
    @GetMapping("selectTechByPrimaryKey")
    public ResultData selectTechByPrimaryKey(@RequestParam("id") Object id);

    /**
     * @Author: He create on 2020/5/24 23:39
     * @param: [technicist]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 添加技术人员信息
     */
    @PutMapping("insertTech")
    public ResultData insertTech(@RequestBody Technicist technicist);

    /**
     * @Author: He create on 2020/5/24 23:40
     * @param: [technicist]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id修改技术人员信息
     */
    @PostMapping("updateTechByPrimaryKey")
    public ResultData updateTechByPrimaryKey(@RequestBody Technicist technicist);

    /**
     * @Author: He create on 2020/5/24 23:40
     * @param: [technicist]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键删除技术人员信息
     */
    @DeleteMapping("deleteTechByPrimaryKey")
    public ResultData deleteTechByPrimaryKey(@RequestParam("id") Object id);

}

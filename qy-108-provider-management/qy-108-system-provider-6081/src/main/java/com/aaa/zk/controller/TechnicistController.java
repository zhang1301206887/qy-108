package com.aaa.zk.controller;
/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/24 21:31
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Technicist;
import com.aaa.zk.service.TechnicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class TechnicistController extends BaseController {

    @Autowired
    private TechnicistService technicistService;

    /**
    * @Author: He create on 2020/5/24 23:39
    * @param: []
    * @return: com.aaa.zk.base.ResultData
    * @Description: 查询所有的技术人员信息
    */
    @GetMapping("selectAllTech")
    public ResultData selectAllTech(){
        List<Technicist> technicists = technicistService.selectAllTech();
        if (null != technicists){
            return selelctSuccess(technicists);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/24 23:39
    * @param: [map]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据公司id查询技术人员信息
    */
    @PostMapping("selectTechByUserId")
    public ResultData selectTechByUserId(@RequestBody HashMap map){
        List<Technicist> selectTechByUserId = technicistService.selectTechByUserId(map.get("userid"));
        if (null != selectTechByUserId){
            return selelctSuccess(selectTechByUserId);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/24 23:39
    * @param: [technicist]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id查询技术人员信息
    */
    @PostMapping("selectTechByPaimaryKey")
    public ResultData selectTechByPrimaryKey(@RequestBody Technicist technicist){
        Technicist technicist1 = technicistService.selectTechByPrimaryKey(technicist);
        if (null != technicist1){
            return selelctSuccess(technicist1);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/24 23:39
    * @param: [technicist]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加技术人员信息
    */
    @PutMapping("insertTech")
    public ResultData insertTech(@RequestBody Technicist technicist){
        Integer integer = technicistService.insertTech(technicist);
        if (integer > 0){
            return insertSuccess();
        }
        return insertFalied();
    }
    /**
    * @Author: He create on 2020/5/24 23:40
    * @param: [technicist]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id修改技术人员信息
    */
    @PostMapping("updateTechByPrimaryKey")
    public ResultData updateTechByPrimaryKey(@RequestBody Technicist technicist){
        Integer integer = technicistService.updateTechByPrimaryKey(technicist);
        if (integer > 0){
            return updataSuccess();
        }
        return updateFalied();
    }
    /**
    * @Author: He create on 2020/5/24 23:40
    * @param: [technicist]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键删除技术人员信息
    */
    @DeleteMapping("deleteTechByPaimaryKey")
    public ResultData deleteTechByPaimaryKey(@RequestBody Technicist technicist){
        Integer integer = technicistService.deleteTechByPrimaryKey(technicist);
        if (integer > 0){
            return deleteSuccess();
        }
        return deleteFalied();
    }
}

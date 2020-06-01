package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/26 11:39
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Principal;
import com.aaa.zk.service.PrincipaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PrincipalController extends BaseController {
    @Autowired
    private PrincipaService principaService;

    /**
    * @Author: He create on 2020/5/26 15:08
    * @param: [userId]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据公司id查询负责人信息
    */
    @GetMapping("selectPrinByUserId")
    public ResultData selectPrinByUserId(@RequestParam("userId") Object userId){
        Map principal = principaService.selectPrinByUserId(userId);
        if (null != principal){
            return selelctSuccess(principal);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/26 15:08
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id查询负责人信息和对应的附件信息
    */
    @GetMapping("selectPrinByPrimaryKey")
    public ResultData selectPrinByPrimaryKey(@RequestParam("id") Object id){
        Map map = principaService.selectPrinByPrimaryKey(id);
        if (null != map){
            return selelctSuccess(map);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/26 15:10
    * @param: [principal]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加新的负责人信息
    */
    @PutMapping("insertPrin")
    public ResultData insertPrin(@RequestBody Principal principal){
        Integer insertPrin = principaService.insertPrin(principal);
        if(insertPrin > 0){
            return insertSuccess();
        }
        return insertFalied();
    }
    /**
    * @Author: He create on 2020/5/26 15:13
    * @param: [principal]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id更新负责人信息
    */
    @PostMapping("updatePrinByPrimaryKey")
    public ResultData updatePrinByPrimaryKey(@RequestBody Principal principal){
        Integer updatePrinByPrimaryKey = principaService.updatePrinByPrimaryKey(principal);
        if(updatePrinByPrimaryKey > 0){
            return updataSuccess();
        }
        return updateFalied();
    }
    /**
    * @Author: He create on 2020/5/26 15:13
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id删除负责人信息
    */
    @DeleteMapping("deletePrinByPrimaryKey")
    public ResultData deletePrinByPrimaryKey(@RequestParam("id") Object id){
        Integer deletePrinByPrimaryKey = principaService.deletePrinByPrimaryKey(id);
        if(deletePrinByPrimaryKey > 0){
            return deleteSuccess();
        }
        return deleteFalied();
    }
}

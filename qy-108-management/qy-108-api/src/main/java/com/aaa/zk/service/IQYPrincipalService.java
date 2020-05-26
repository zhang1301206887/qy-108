package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/26 15:02
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Principal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "prin-interface")
public interface IQYPrincipalService {
    /**
     * @Author: He create on 2020/5/26 15:08
     * @param: [userId]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据公司id查询负责人信息
     */
    @GetMapping("selectPrinByUserId/{userId}")
    public ResultData selectPrinByUserId(@PathVariable("userId") Object userId);
    /**
     * @Author: He create on 2020/5/26 15:08
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id查询负责人信息
     */
    @GetMapping("selectPrinByPrimaryKey/{id}")
    public ResultData selectPrinByPrimaryKey(@PathVariable("id") Object id);
    /**
     * @Author: He create on 2020/5/26 15:10
     * @param: [principal]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 添加新的负责人信息
     */
    @PutMapping("insertPrin")
    public ResultData insertPrin(@RequestBody Principal principal);
    /**
     * @Author: He create on 2020/5/26 15:13
     * @param: [principal]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id更新负责人信息
     */
    @PostMapping("updatePrinByPrimaryKey")
    public ResultData updatePrinByPrimaryKey(@RequestBody Principal principal);
    /**
     * @Author: He create on 2020/5/26 15:13
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id删除负责人信息
     */
    @DeleteMapping("deletePrinByPrimaryKey")
    public ResultData deletePrinByPrimaryKey(@RequestBody Long id);
}

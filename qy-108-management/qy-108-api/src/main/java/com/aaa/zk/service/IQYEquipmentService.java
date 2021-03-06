package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/26 17:13
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Equipment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "equi-interface")
public interface IQYEquipmentService {
    /**
     * @Author: He create on 2020/5/26 16:56
     * @param: [userId]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据公司id查询设备信息
     */
    @GetMapping("selectEquiByUserId")
    public ResultData selectEquiByUserId(@RequestParam("userId") Object userId,@RequestParam("pageNo") Integer pageNo,
                                         @RequestParam("pageSize") Integer pageSize);
    /**
     * @Author: He create on 2020/5/26 16:55
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id查询设备信息
     */
    @GetMapping("selectEquiByPrimaryKey")
    public ResultData selectEquiByPrimaryKey(@RequestParam("id") Object id);
    /**
     * @Author: He create on 2020/5/26 16:55
     * @param: [equipment]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 添加新设备信息
     */
    @PutMapping("insertEqui")
    public ResultData insertEqui(@RequestBody Equipment equipment);
    /**
     * @Author: He create on 2020/5/26 16:55
     * @param: [equipment]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id更新设备信息
     */
    @PostMapping("updateEquiByPrimaryKey")
    public ResultData updateEquiByPrimaryKey(@RequestBody Equipment equipment);
    /**
     * @Author: He create on 2020/5/26 16:54
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id删除设备数据
     */
    @DeleteMapping("deleteEquiByPrimaryKey")
    public ResultData deleteEquiByPrimaryKey(@RequestParam("id") Object id);
}

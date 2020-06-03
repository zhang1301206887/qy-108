package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/26 16:42
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.CommonController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Dept;
import com.aaa.zk.model.Equipment;
import com.aaa.zk.service.EquipmentService;
import com.aaa.zk.utils.Map2BeanUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EquipmentController extends CommonController<Equipment> {

    @Autowired
    private EquipmentService equipmentService;

    public BaseService<Equipment> getBaseService() {
        return equipmentService;
    }
    /**
    * @Author: He create on 2020/5/26 16:56
    * @param: [userId]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据公司id查询设备信息
    */
    @GetMapping("selectEquiByUserId")
    public ResultData selectEquiByUserId(@RequestParam("userId") Object userId,@RequestParam("pageNo") Integer pageNo,
                                         @RequestParam("pageSize") Integer pageSize){
        PageInfo<Equipment> pageInfo = equipmentService.selectEquiByUserId(userId,pageNo,pageSize);
        if (null != pageInfo && !"".equals(pageInfo)){
            return selelctSuccess(pageInfo);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/26 16:55
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id查询设备信息
    */
    @GetMapping("selectEquiByPrimaryKey")
    public ResultData selectEquiByPrimaryKey(@RequestParam("id") Object id){
        Map map = equipmentService.selectEquiByPrimaryKey(id);
        if (null != map){
            return selelctSuccess(map);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/26 16:55
    * @param: [equipment]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加新设备信息
    */
    @PutMapping("insertEqui")
    public ResultData insertEqui(@RequestBody Equipment equipment){
        Integer insertEqui = equipmentService.insertEqui(equipment);
        if (insertEqui > 0){
            return insertSuccess();
        }
        return insertFalied();
    }
    /**
    * @Author: He create on 2020/5/26 16:55
    * @param: [equipment]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id更新设备信息
    */
    @PostMapping("updateEquiByPrimaryKey")
    public ResultData updateEquiByPrimaryKey(@RequestBody Equipment equipment){
        Integer update = equipmentService.updateEquiByPrimaryKey(equipment);
        if (update > 0){
            return updataSuccess();
        }
        return updateFalied();
    }
    /**
    * @Author: He create on 2020/5/26 16:54
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id删除设备数据
    */
    @DeleteMapping("deleteEquiByPrimaryKey")
    public ResultData deleteEquiByPrimaryKey(@RequestParam("id") Object id){
        Integer deleteEquiByPrimaryKey = equipmentService.deleteEquiByPrimaryKey(id);
        if (deleteEquiByPrimaryKey > 0){
            return deleteSuccess();
        }
        return deleteFalied();
    }

}

package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 12:03
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "menu-interface")
public interface IQYMenuService {

    /**
    * @Author: He create on 2020/5/22 12:06
    * @param: [menu]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 条件查询菜单
    */
    @GetMapping("selectMenuByField")
    ResultData selectMenuByField(@RequestBody Menu menu);

    /**
    * @Author: He create on 2020/5/22 12:06
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 查询菜单表所有信息 并且把子菜单放在父级菜单下（传入的id应为最大父级id 0）
    */
    @GetMapping("selectMenuByParentId")
    ResultData selectMenuByParentId(@RequestParam Object id);

    /**
    * @Author: He create on 2020/5/22 12:07
    * @param: [menu]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加新菜单
    */
    @PutMapping("insertMenu")
    ResultData insertMenu(@RequestBody Menu menu);

    /**
    * @Author: He create on 2020/5/22 12:07
    * @param: [menu]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 更新数据
    */
    @PostMapping("updateMenuByPrimaryKey")
    ResultData updateByPrimaryKey(@RequestBody Menu menu);

    /**
    * @Author: He create on 2020/5/22 12:07
    * @param: [menu]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 删除一条数据
    */
    @DeleteMapping("deleteMenuByPrimaryKey")
    ResultData deleteMenuByPrimaryKey(@RequestBody Menu menu);

    /**
    * @Author: He create on 2020/5/22 12:08
    * @param: [list]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 批量删除
    */
    @DeleteMapping("deleteMenuByPrimaryKeyList")
    ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list);
}
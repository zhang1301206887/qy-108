package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 11:49
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Dict;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "dict-interface")
public interface IQYDictService {
    /**
    * @Author: He create on 2020/5/22 11:51
    * @param: []
    * @return: com.aaa.zk.base.ResultData
    * @Description: 查询所有字典表信息
    */
    @GetMapping("/selectAllDict")
    ResultData selectAll();
    /**
    * @Author: He create on 2020/5/22 11:51
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 条件查询
    */
    @GetMapping("/selectDictByField")
    ResultData selectByField(@RequestBody Dict dict);
    /**
    * @Author: He create on 2020/5/22 11:51
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加数据
    */
    @PutMapping("/insertDict")
    ResultData insertDict(@RequestBody Dict dict);
    /**
    * @Author: He create on 2020/5/22 11:51
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id进行数据的修改
    */
    @PostMapping("/updateDictByPrimaryKey")
    ResultData updateByPrimaryKey(@RequestBody Dict dict);
    /**
    * @Author: He create on 2020/5/22 11:52
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 删除数据
    */
    @DeleteMapping("/deleteDictByPrimaryKey")
    ResultData deleteByPrimaryKey(@RequestBody Dict dict);
    /**
    * @Author: He create on 2020/5/22 11:52
    * @param: [list]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 批量删除
    */
    @DeleteMapping("deleteDictByPrimaryKeyList")
    ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list);
}

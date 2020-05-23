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
    ResultData selectAllDict();
    /**
    * @Author: He create on 2020/5/22 11:51
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 条件查询字典信息
    */
    @PostMapping("/selectDictByField")
    ResultData selectDictByField(@RequestBody Dict dict);
    /**
    * @Author: He create on 2020/5/22 11:51
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加字典新数据
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
    ResultData updateDictByPrimaryKey(@RequestBody Dict dict);
    /**
    * @Author: He create on 2020/5/22 11:52
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id删除字典信息
    */
    @DeleteMapping("/deleteDictByPrimaryKey")
    ResultData deleteDictByPrimaryKey(@RequestBody Object id);
    /**
    * @Author: He create on 2020/5/22 11:52
    * @param: [list]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id批量删除字典信息
    */
    @DeleteMapping("deleteDictByPrimaryKeyList")
    ResultData deleteDictByPrimaryKeyList(@RequestBody List<Map> list);
}

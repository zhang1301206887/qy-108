package com.aaa.zk.controller;
/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/22 11:52
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Dict;
import com.aaa.zk.service.IQYDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "字典信息", tags = "字典信息管理")
public class DictController extends BaseController {
    @Autowired
    private IQYDictService dictService;

    @GetMapping("/selectAllDict")
    @ApiOperation(value = "查询功能",notes = "查询所有的字典数据")
    public ResultData selectAllDict(){
        return dictService.selectAllDict();
    }

    @PostMapping("/selectDictByField")
    @ApiOperation(value = "查询功能",notes = "条件查询字典数据")
    public ResultData selectDictByField(@RequestBody Dict dict){
        return dictService.selectDictByField(dict);
    }

    @PutMapping("/insertDict")
    @ApiOperation(value = "添加功能",notes = "添加新字典数据")
    public ResultData insertDict(@RequestBody Dict dict){
        return dictService.insertDict(dict);
    }

    @PostMapping("/updateDictByPrimaryKey")
    @ApiOperation(value = "更新功能",notes = "根据主键id更新字典数据")
    public ResultData updateDictByPrimaryKey(@RequestBody Dict dict){
        return dictService.updateDictByPrimaryKey(dict);
    }

    @DeleteMapping("/deleteDictByPrimaryKey")
    @ApiOperation(value = "删除功能",notes = "根据主键id删除字典数据")
    public ResultData deleteDictByPrimaryKey(@RequestBody Object id){
        return dictService.deleteDictByPrimaryKey(id);
    }

    @DeleteMapping("deleteDictByPrimaryKeyList")
    @ApiOperation(value = "删除功能",notes = "根据主键id批量删除字典数据")
    public ResultData deleteDictByPrimaryKeyList(@RequestBody List<Map> list){
        return dictService.deleteDictByPrimaryKeyList(list);
    }
}

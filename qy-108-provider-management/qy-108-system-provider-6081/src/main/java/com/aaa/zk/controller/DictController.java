package com.aaa.zk.controller;
/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/20 21:18
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Dict;
import com.aaa.zk.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;


    /**
    * @Author: He create on 2020/5/20 21:37
    * @param: []
    * @return: com.aaa.zk.base.ResultData
    * @Description: 查询所有数据
    */
    @GetMapping("/selectAllDict")
    public ResultData selectAll(){
        List<Dict> dicts = dictService.selectAllDict();
        if (null != dicts){
            return selelctSuccess(dicts);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/26 14:42
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据id查询字典表信息
    */
    @GetMapping("selectDictByPrimaryKey")
    public ResultData selectDictByPaimaryKey(@RequestParam("id") Object id){
        Dict dict = dictService.selectDictByPrimaryKey(id);
        if (null != dict){
            return selelctSuccess(dict);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/20 21:37
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据条件查询数据
    */
    @PostMapping("/selectDictByField")
    public ResultData selectByField(@RequestBody Map map){
        List<Dict> dicts = dictService.selectDictByFiled(map);
        if (null != dicts){
            return selelctSuccess(dicts);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/20 21:37
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加数据
    */
    @PutMapping("/insertDict")
    public ResultData insertDict(@RequestBody Dict dict){
        Integer insertResult = dictService.insertDict(dict);
        if (insertResult > 0){
            return insertSuccess();
        }
        return insertFalied();
    }
    /**
    * @Author: He create on 2020/5/20 21:36
    * @param: [dict]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据id 更新数据
    */
    @PostMapping("/updateDictByPrimaryKey")
    public ResultData updateByPrimaryKey(@RequestBody Dict dict){
        Integer updateResult = dictService.updateDictByPrimaryKey(dict);
        if (updateResult > 0){
            return updataSuccess();
        }
        return updateFalied();
    }
    /**
    * @Author: He create on 2020/5/20 21:36
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id删除 数据
    */
    @DeleteMapping("/deleteDictByPrimaryKey")
    public ResultData deleteByPrimaryKey(@RequestParam("id") Object id){
        Integer deleteResult = dictService.delectDictByPrimaryKey(id);
        if (deleteResult > 0){
            return deleteSuccess();
        }
        return deleteFalied();
    }
    /**
     * @Author: He create on 2020/5/21 23:25
     * @param: [list]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据前台传入的list  遍历map id 进行删除操作
     */
    @DeleteMapping("deleteDictByPrimaryKeyList")
    public ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list){
        Integer integer = dictService.deleteDictByPrimaryKeyList(list);
        if (integer > 0){
            return deleteSuccess("删除成功，共"+integer+"数据！");
        }
        return deleteFalied();
    }
}

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

@RestController("dict")
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
        List<Dict> dicts = dictService.selectAll();
        if (null != dicts){
            return selelctSuccess(dicts);
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
    public ResultData selectByField( Dict dict){
        dict.setTableName("t_user");
        List<Dict> dicts = dictService.selectByFiled(dict);
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
    @PostMapping("/insertDict")
    public ResultData insertDict( Dict dict){
        dict.setKeyy(0L);
        dict.setValuee("测试");
        dict.setTableName("t_test");
        dict.setFieldName("test");
        Integer insertResult = dictService.insert(dict);
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
    public ResultData updateByPrimaryKey(Dict dict){
        dict.setDictId(34L);
        dict.setValuee("测试测试");
        dict.setKeyy(0L);
        dict.setTableName("t_test");
        dict.setFieldName("test");
        Integer updateResult = dictService.updateByPrimaryKey(dict);
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
    @PostMapping("/deleteDictByPrimaryKey")
    public ResultData deleteByPrimaryKey(Dict dict){
        dict.setDictId(34L);
        Integer deleteResult = dictService.delectByPrimaryKey(dict);
        if (deleteResult > 0){
            return deleteSuccess();
        }
        return deleteFalied();
    }
}

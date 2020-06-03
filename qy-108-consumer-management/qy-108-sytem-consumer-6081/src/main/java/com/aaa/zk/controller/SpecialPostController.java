package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.SpecialPost;
import com.aaa.zk.service.IQYSpecialPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zk
 * @Date 2020/5/25
 */
@RestController
@Api(value = "特殊岗位员工信息", tags = "特殊岗位员工管理")
public class SpecialPostController extends BaseController {

    @Autowired
    private IQYSpecialPostService iqySpecialPostService;

    @GetMapping("selectSpecialPostCount")
    @ApiOperation(value = "查询功能", notes = "特殊岗位员工数量查询")
    public ResultData selectSpecialPostCount(@RequestParam("userId") Object userId){
        return iqySpecialPostService.selectSpecialPostCount(userId);
    }

    @GetMapping("selectSpecialPostByUserId")
    @ApiOperation(value = "查询功能",notes = "根据公司id查询特殊岗位员工数据")
    public ResultData selectSpecialPostByUserId(@RequestParam("userId") Object userId){
        return iqySpecialPostService.selectSpecialPostByUserId(userId);
    }

    @GetMapping("selectSpecialByPrimaryKey")
    @ApiOperation(value = "查询功能",notes = "根据id查询特殊岗位员工的数据")
    public ResultData selectSpecialByPrimaryKey(@RequestParam("id") Object id){
        return iqySpecialPostService.selectSpecialByPrimaryKey(id);
    }

    @PutMapping("insertSpecial")
    @ApiOperation(value = "添加功能",notes = "添加新特殊岗位员工数据")
    public ResultData insertSpecial(@RequestBody SpecialPost specialPost){
        return iqySpecialPostService.insertSpecial(specialPost);
    }

    @PostMapping("updateSpecialByPrimaryKey")
    @ApiOperation(value = "修改功能",notes = "根据主键修改特殊岗位员工的数据")
    public ResultData updateSpecialByPrimaryKey(@RequestBody SpecialPost specialPost){
        return iqySpecialPostService.updateSpecialByPrimaryKey(specialPost);
    }

    @DeleteMapping("deleteSpecialByPrimaryKey")
    @ApiOperation(value = "删除功能",notes = "根据主键删除特殊岗位员工数据")
    public ResultData deleteSpecialByPrimaryKey(@RequestParam("id") Object id){
        return iqySpecialPostService.deleteSpecialByPrimaryKey(id);
    }
}

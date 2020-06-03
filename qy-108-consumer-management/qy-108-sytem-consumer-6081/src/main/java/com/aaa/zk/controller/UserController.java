package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingProject;
import com.aaa.zk.model.User;
import com.aaa.zk.service.IQYUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "用户信息", tags = "用户信息管理")
public class UserController extends BaseController {

    @Autowired
    private IQYUserService iqyUserService;

    /**
     * 查询所有用户信息
     * @return
     */
    @PostMapping("/userSelectAll")
    @ApiOperation(value = "用户功能",notes = "查询所有用户")
    public ResultData userSelectAll(@RequestBody Map map){
         return iqyUserService.userSelectAll(map);

    }

    /**
     * 查询一条
     * @param user
     * @return
     */
    @PostMapping("/selectOne")
    @ApiOperation(value = "用户功能",notes = "查询单个用户")
    public ResultData userSelectOne( User user){
        return iqyUserService.userSelectOne(user);

    }

    /**
     * @Author: He create on 2020/5/29 22:34
     * @param: [map]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 多条件查询用户信息
     */
    @PostMapping("selectUserByField")
    @ApiOperation(value = "查询功能",notes = "多条件查询用户信息")
    public ResultData selectUserByField(@RequestBody Map map){
        return iqyUserService.selectUserByField(map);
    }
    /**
     * 添加用户
     * @param user
     * @return
     */
    @PutMapping("/userAdd")
    @ApiOperation(value = "用户功能",notes = "添加用户")
    public ResultData userAdd( User user){
        return iqyUserService.userAdd(user);

    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
    @ApiOperation(value = "用户功能",notes = "修改用户")
    public ResultData userUpdate( User user){
        return iqyUserService.userUpdate(user);

    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @DeleteMapping("/userDelete")
    @ApiOperation(value = "用户功能",notes = "删除用户")
    public ResultData userDelete( User user){
        return iqyUserService.userDelete(user);

    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @PostMapping("/userDeleteAll")
    @ApiOperation(value = "用户功能",notes = "批量删除用户")
    public ResultData userDelete(String id){
        return iqyUserService.userDeleteAll(id);

    }

    /**
     * 密码重置
     * @param user
     * @return
     */
    @PostMapping("/userPassWord")
    @ApiOperation(value = "用户功能",notes = "重置密码")
    public ResultData userPassWord( User user){
        return iqyUserService.userPassWord(user);

    }


}

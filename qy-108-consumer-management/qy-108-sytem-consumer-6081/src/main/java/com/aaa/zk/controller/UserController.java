package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.User;
import com.aaa.zk.service.IQYUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "用户信息", tags = "用户信息管理")
public class UserController extends BaseController {

    @Autowired
    private IQYUserService iqyUserService;

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("/userSelectAll")
    @ApiOperation(value = "用户功能",notes = "查询所有用户")
    public ResultData userSelectAll(){
        List<User> users = iqyUserService.userSelectAll();
        if (users != null && !"".equals(users)){
            return super.selelctSuccess(users);
        }else {
            return super.selelctFalied();
        }
    }

    /**
     * 查询一条
     * @param user
     * @return
     */
    @PostMapping("/selectOne")
    @ApiOperation(value = "用户功能",notes = "查询单个用户")
    public ResultData userSelectOne( User user){
        User user1 = iqyUserService.userSelectOne(user);
        if (user1 != null && !"".equals(user1)){
            return super.selelctSuccess(user1);
        }else {
            return super.selelctFalied();
        }
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PutMapping("/userAdd")
    @ApiOperation(value = "用户功能",notes = "添加用户")
    public ResultData userAdd( User user){
        Integer integer = iqyUserService.userAdd(user);
        if (integer>0){
            return super.insertSuccess();
        }else {
            return super.insertFalied();
        }
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
    @ApiOperation(value = "用户功能",notes = "修改用户")
    public ResultData userUpdate( User user){
        Integer integer = iqyUserService.userUpdate(user);
        if (integer>0){
            return super.updataSuccess();
        }else {
            return super.updateFalied();
        }
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @DeleteMapping("/userDelete")
    @ApiOperation(value = "用户功能",notes = "删除用户")
    public ResultData userDelete( User user){
        Integer integer = iqyUserService.userDelete(user);
        if (integer>0){
            return super.deleteSuccess();
        }else {
            return super.deleteFalied();
        }
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @PostMapping("/userDeleteAll")
    @ApiOperation(value = "用户功能",notes = "批量删除用户")
    public ResultData userDelete( String id){
        Integer integer = iqyUserService.userDeleteAll(id);
        if (integer>0){
            return super.deleteSuccess();
        }else {
            return super.deleteFalied();
        }
    }

    /**
     * 密码重置
     * @param user
     * @return
     */
    @PostMapping("/userPassWord")
    @ApiOperation(value = "用户功能",notes = "重置密码")
    public ResultData userPassWord( User user){
        Integer integer = iqyUserService.userPassWord(user);
        if (integer>0){
            return super.updataSuccess();
        }else {
            return super.updateFalied();
        }
    }
    /**
     * 用户重置
     * @param user
     * @return
     */
    @PostMapping("/resetUser")
    @ApiOperation(value = "用户功能",notes = "用户重置")
    public ResultData resetUser( User user){
        Integer integer = iqyUserService.resetUser(user);
        if (integer>0){
            return super.updataSuccess();
        }else {
            return super.updateFalied();
        }
    }

}

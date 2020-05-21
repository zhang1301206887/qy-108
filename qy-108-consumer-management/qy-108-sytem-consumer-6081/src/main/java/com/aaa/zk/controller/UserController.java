package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.User;
import com.aaa.zk.service.IQYUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController extends BaseController {

    @Autowired
    private IQYUserService iqyUserService;

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("userSelectAll")
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
    @PostMapping("SelectOne")
    public ResultData userSelectOne(User user){
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
    @PutMapping("userAdd")
    public ResultData userAdd(User user){
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
    @PostMapping("userUpdate")
    public ResultData userUpdate(User user){
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
    @DeleteMapping("userDelete")
    public ResultData userDelete(User user){
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
    @PostMapping("userDeleteAll")
    public ResultData userDelete(@RequestParam String id){
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
    @PostMapping("userPassWord")
    public ResultData userPassWord(User user){
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
    @PostMapping("resetUser")
    public ResultData resetUser(User user){
        Integer integer = iqyUserService.resetUser(user);
        if (integer>0){
            return super.updataSuccess();
        }else {
            return super.updateFalied();
        }
    }

}

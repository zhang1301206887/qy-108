package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.CommonController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.User;
import com.aaa.zk.service.UserService;
import com.aaa.zk.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;
import java.util.Map;


@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;


    @PostMapping("/userSelectAllByPage")
    public ResultData userSelectAllByPage(@RequestParam("pageNo") Integer pageNo,@RequestParam("PageSize") Integer pageSize){
        PageInfo<User> pageInfo = userService.selectAllByPage(pageNo,pageSize);
        if (null != pageInfo && !"".equals(pageInfo)){
            return selelctSuccess(pageInfo);
        }
        return selelctFalied();
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/selectAll")
    public ResultData userSelectAll(){
        List<User> users = userService.userSlelectAll();
        if (users !=null && !"".equals(users)){
            return selelctSuccess(users);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/29 22:34
    * @param: [map]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 多条件查询用户信息
    */
    @PostMapping("selectUserByField")
    public ResultData selectUserByField(@RequestBody Map map){
        PageInfo<User> pageInfo = userService.selectUserByField(map);
        if (null != pageInfo && !"".equals(pageInfo)){
            return selelctSuccess(pageInfo);
        }
        return selelctFalied();
    }
    /**
     * 查询一条
     * @param user
     * @return
     */
    @PostMapping("/selectOne")
    public ResultData userSelectOne(@RequestBody User user){
        User user1 = userService.userSelectOne(user);
        if (user1 != null && !"".equals(user1)){
            return selelctSuccess(user1);
        }else {
            return selelctFalied();
        }
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/userAdd")
    public ResultData userAdd(@RequestBody User user){
        Integer integer = userService.userAdd(user);
        if (integer>0){
            return insertSuccess();
        }else {
            return insertFalied();
        }
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
    public ResultData userUpdate(@RequestBody User user){
        Integer integer = userService.userUpdate(user);
        if (integer>0){
            return updataSuccess();
        }else {
            return updateFalied();
        }
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping("/userDelete")
    public ResultData userDelete(@RequestBody User user){
        Integer integer = userService.userDelete(user);
        if (integer>0){
            return deleteSuccess();
        }else {
            return deleteFalied();
        }
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @PostMapping("/userDeleteAll")
    public ResultData userDeleteAll(@RequestBody String id){
        Integer integer = userService.userDeleteAll(id);
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
    @PostMapping("/userPassword")
    public ResultData userPassWord(@RequestBody User user){
        Integer integer = userService.UserPassword(user);
        if (integer>0){
            return updataSuccess();
        }else {
            return updateFalied();
        }
    }

}

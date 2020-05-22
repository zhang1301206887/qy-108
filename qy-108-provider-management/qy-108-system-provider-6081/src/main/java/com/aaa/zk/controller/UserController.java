package com.aaa.zk.controller;

import com.aaa.zk.model.User;
import com.aaa.zk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/selectAll")
    public List<User> userSelectAll(){
        return userService.userSlelectAll();
    }

    /**
     * 查询一条
     * @param user
     * @return
     */
    @PostMapping("/selectOne")
    public User userSelectOne(@RequestBody User user){
        System.out.println("***"+user);
        return userService.userSelectOne(user);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/userAdd")
    public Integer userAdd(@RequestBody User user){
        System.out.println("***"+user);
         return userService.userAdd(user);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
    public Integer userUpdate(@RequestBody User user){
        System.out.println("8888"+user);
         return userService.userUpdate(user);
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping("/userDelete")
    public Integer userDelete(@RequestBody User user){
        return userService.userDelete(user);
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @PostMapping("/userDeleteAll")
    public Integer userDeleteAll(@RequestBody String id){
        System.out.println("****"+id);
       return userService.userDeleteAll(id);
    }

    /**
     * 密码重置
     * @param user
     * @return
     */
    @PostMapping("/userPassword")
    public Integer userPassWord(@RequestBody User user){
        return userService.UserPassword(user);
    }

    /**
     * 用户重置
     * @param user
     * @return
     */
    @PostMapping("/resetUser")
    public Integer resetUser(@RequestBody User user){
        return userService.resetUser(user);
    }


}

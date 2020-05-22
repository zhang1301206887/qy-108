package com.aaa.zk.service;

import com.aaa.zk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "user-interface")
public interface IQYUserService {

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/selectAll")
     List<User> userSelectAll();

    /**
     * 查询一条
     * @param user
     * @return
     */
    @PostMapping("/selectOne")
     User userSelectOne(@RequestBody User user);


    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/userAdd")
     Integer userAdd(@RequestBody User user);
    /**
     * 修改用户
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
     Integer userUpdate(@RequestBody User user);
    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping("/userDelete")
     Integer userDelete(@RequestBody User user);

    /**
     * 批量删除
     * @param id
     * @return
     */
    @PostMapping("/userDeleteAll")
     Integer userDeleteAll(@RequestBody String id);
    /**
     * 密码重置
     * @param user
     * @return
     */
    @PostMapping("/userPassword")
     Integer userPassWord(@RequestBody User user);

    /**
     * 用户重置
     * @param user
     * @return
     */
    @PostMapping("/resetUser")
     Integer resetUser(@RequestBody User user);
}
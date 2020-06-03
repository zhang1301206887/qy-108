package com.aaa.zk.service;

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(value = "user-interface")
public interface IQYUserService {

    /**
     * 查询所有
     * @return
     */
    @PostMapping("/selectAll")
     ResultData userSelectAll(@RequestBody Map map);

    /**
     * 查询一条
     * @param user
     * @return
     */
    @PostMapping("/selectOne")
    ResultData userSelectOne(@RequestBody User user);

    /**
     * @Author: He create on 2020/5/29 22:34
     * @param: [map]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 多条件查询用户信息
     */
    @PostMapping("selectUserByField")
    public ResultData selectUserByField(@RequestBody Map map);

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/userAdd")
    ResultData userAdd(@RequestBody User user);
    /**
     * 修改用户
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
    ResultData userUpdate(@RequestBody User user);
    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping("/userDelete")
    ResultData userDelete(@RequestBody User user);

    /**
     * 批量删除
     * @param id
     * @return
     */
    @PostMapping("/userDeleteAll")
    ResultData userDeleteAll(@RequestBody String id);
    /**
     * 密码重置
     * @param user
     * @return
     */
    @PostMapping("/userPassword")
    ResultData userPassWord(@RequestBody User user);

}

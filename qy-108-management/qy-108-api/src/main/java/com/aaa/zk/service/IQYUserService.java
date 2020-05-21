package com.aaa.zk.service;

import com.aaa.zk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "system-interface")
public interface IQYUserService {

    /**
     * 查询所有
     * @return
     */
     List<User> userSelectAll();

    /**
     * 查询一条
     * @param user
     * @return
     */
     User userSelectOne(User user);


    /**
     * 添加用户
     * @param user
     * @return
     */
     Integer userAdd(User user);
    /**
     * 修改用户
     * @param user
     * @return
     */
     Integer userUpdate(User user);
    /**
     * 删除用户
     * @param user
     * @return
     */
     Integer userDelete(User user);

    /**
     * 批量删除
     * @param id
     * @return
     */
     Integer userDeleteAll(@RequestParam String id);
    /**
     * 密码重置
     * @param user
     * @return
     */
     Integer userPassWord(User user);

    /**
     * 用户重置
     * @param user
     * @return
     */
     Integer resetUser(User user);
}

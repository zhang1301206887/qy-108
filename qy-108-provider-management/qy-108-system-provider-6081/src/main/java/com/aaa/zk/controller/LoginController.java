package com.aaa.zk.controller;

import com.aaa.zk.model.LoginLog;
import com.aaa.zk.model.User;
import com.aaa.zk.redis.RedisService;
import com.aaa.zk.service.LoginLogService;
import com.aaa.zk.service.LoginService;
import com.aaa.zk.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zk
 * @Date 2020/5/17
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisService redisService;
    /**
     * @Author: He create on 2020/5/15 22:30
     * @param: [user]
     * @return: com.aaa.hk.vo.TokenVo
     * @Description: 登录操作
     */
    @PostMapping("/doLogin")
    public TokenVo doLogin(@RequestBody User user){
        return loginService.doLogin(user, redisService);
    }
}

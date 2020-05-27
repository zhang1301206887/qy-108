package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/27 22:28
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.CommonController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.LoginLog;
import com.aaa.zk.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class LoginLogController extends CommonController<LoginLog> {

    @Autowired
    private LoginLogService loginLogService;

    public BaseService<LoginLog> getBaseService() {
        return loginLogService;
    }
    /**
    * @Author: He create on 2020/5/27 22:39
    * @param: [map]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 实现登录日志的添加
    */
    @PostMapping("/addLoginLog")
    public ResultData addLoginLog(@RequestBody Map map) {
        return super.add(map);
    }
}

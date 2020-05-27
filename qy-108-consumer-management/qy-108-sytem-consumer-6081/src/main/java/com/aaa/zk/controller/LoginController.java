package com.aaa.zk.controller;

import com.aaa.zk.annotation.LoginLogAnnotation;
import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.User;
import com.aaa.zk.service.IQYService;
import com.aaa.zk.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zk
 * @Date 2020/5/17
 */
@RestController
@Api(value = "登录信息", tags = "用户登录接口")
public class LoginController extends BaseController {

    @Autowired
    private IQYService qyservice;

    /**
     *      执行登录操作
     **/
    @PostMapping("/doLogin")
    @ApiOperation(value = "登录功能",notes = "用户执行登录功能")
    @LoginLogAnnotation(operationType = "登录操作", operationName = "管理员登录")
    public ResultData doLogin(@RequestBody User user){
        TokenVo tokenVo = qyservice.doLogin(user);
        if (tokenVo.getIfSuccess()){
            return super.loginSuccess(tokenVo.getToken());
        }
        return super.loginFailed();
    }

}

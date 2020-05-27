package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/15 22:44
 *@Description:
 */


import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.LoginLogMapper;
import com.aaa.zk.model.LoginLog;
import com.aaa.zk.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aaa.zk.status.CURDStatus.CRUD_FALIED;

@Service
public class LoginLogService extends BaseService<LoginLog> {
}

package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/29 22:27
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.service.IQYResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "资源信息", tags = "资源信息管理")
public class ResourceController extends BaseController {
    @Autowired
    private IQYResourceService resourceService;

    @GetMapping("selectResourceById/{id}")
    @ApiOperation(value = "查询功能",notes = "根据单位id查询所有的资源数据")
    public ResultData selectResourceById(@PathVariable("id") Object id){
        return resourceService.selectResourceById(id);
    }
}

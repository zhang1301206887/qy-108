package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.service.IQYSpecialPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zk
 * @Date 2020/5/25
 */
@RestController
@Api(value = "特岗员工信息", tags = "特岗员工管理")
public class SpecialPostController extends BaseController {

    @Autowired
    private IQYSpecialPostService iqySpecialPostService;

    @PostMapping("/selectSpecialPostCount")
    @ApiOperation(value = "查询功能", notes = "特岗员工数量查询")
    public ResultData selectSpecialPostCount(@RequestBody Object userId){
        Integer i = iqySpecialPostService.selectSpecialPostCount(userId);
        if (i > 0){
            return super.selelctSuccess(i);
        }else{
            return super.selelctFalied();
        }
    }


}

package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Resource;
import com.aaa.zk.service.IQYResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zk
 * @Date 2020/5/29
 */
@RestController
@Api(value = "附件材料信息", tags = "附件材料信息管理")
public class ResourceController extends BaseController {

    @Autowired
    private IQYResourceService iqyResourceService;
    /**
     * @author zk
     * @Date
     *   根据refBizId查询附件材料
     */
    @GetMapping("selectResourceByRefBizId/{id}")
    @ApiOperation(value = "查询功能",notes = "根据项目id查询附件材料")
    public ResultData selectResourceByRefBizId(@PathVariable("id") Object id){
        List<Resource> list = iqyResourceService.selectResourceByRefBizId(id);
        if (null != list && !"".equals(list)){
            return selelctSuccess(list);
        }else{
            return selelctFalied();
        }
    }
    @GetMapping("selectResourceById")
    @ApiOperation(value = "查询功能",notes = "根据单位id查询所有的资源数据")
    public ResultData selectResourceById(@RequestParam("id") Object id){
        return iqyResourceService.selectResourceById(id);
    }
}

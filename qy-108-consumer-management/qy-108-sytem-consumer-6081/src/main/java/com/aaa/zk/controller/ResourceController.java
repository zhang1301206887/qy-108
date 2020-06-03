package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Resource;
import com.aaa.zk.service.IQYResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("selectResourceByPrimaryKey")
    @ApiOperation(value = "查询功能",notes = "根据附件id查询附件材料")
    public ResultData selectResourceByPrimaryKey(@RequestParam("id") Object id){
        return iqyResourceService.selectResourceByPrimaryKey(id);
    }
    @GetMapping("selectResourceById")
    @ApiOperation(value = "查询功能",notes = "根据单位id查询所有的附件数据")
    public ResultData selectResourceById(@RequestParam("id") Object id){
        return iqyResourceService.selectResourceById(id);
    }
    @PostMapping("updateResourceById")
    @ApiOperation(value = "更新功能",notes = "根据主键id更新附件数据")
    public ResultData updateResourceById(@RequestBody Resource resource){
        return iqyResourceService.updateResourceById(resource);
    }
    @PutMapping("insertResource")
    @ApiOperation(value = "新增功能",notes = "新增附件数据")
    public ResultData insertResource(@RequestBody Resource resource){
        return iqyResourceService.insertResource(resource);
    }
}

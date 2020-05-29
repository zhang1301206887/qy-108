package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/29 21:38
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.CommonController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Resource;
import com.aaa.zk.service.ResoucreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController extends CommonController<Resource> {
    @Autowired
    private ResoucreService resoucreService;
    public BaseService<Resource> getBaseService() {
        return resoucreService;
    }
    /**
    * @Author: He create on 2020/5/29 22:24
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据单位id查询资源信息 选择展示
    */
    @GetMapping("selectResourceById/{id}")
    public ResultData selectResourceById(@PathVariable("id") Object id){
        try {
            Resource resource = new Resource().setRefBizId(Long.valueOf(id.toString()));
            List<Resource> resources = resoucreService.queryList(resource);
            if (null != resources && resources.size() > 0){
                return selelctSuccess(resources);
            }
            return selelctFalied();
        }catch (Exception e){
            e.printStackTrace();
        }
       return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/29 22:25
    * @param: [resource]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 修改信息
    */
    @PostMapping("updateResourceById")
    public ResultData updateResourceById(@RequestBody Resource resource){
        try {
            Integer update = resoucreService.update(resource);
            if (update > 0){
                return updataSuccess();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateFalied();
    }
}

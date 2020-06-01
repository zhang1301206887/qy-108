package com.aaa.zk.service;

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author zk
 * @Date 2020/5/29
 */
@FeignClient(value = "resource-interface")
public interface IQYResourceService {

    /**
     * @author zk
     * @Date
     *       根据项目id查询附件材料
     */
    @GetMapping("selectResourceByRefBizId/{id}")
    List<Resource> selectResourceByRefBizId(@PathVariable("id") Object id);
    /**
     * @Author: He create on 2020/5/29 22:24
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据单位id查询资源信息 选择展示
     */
    @GetMapping("selectResourceById")
    public ResultData selectResourceById(@RequestParam("id") Object id);

}

package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/29 22:25
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "resource-interface")
public interface IQYResourceService {
    /**
     * @Author: He create on 2020/5/29 22:24
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据单位id查询资源信息 选择展示
     */
    @GetMapping("selectResourceById/{id}")
    public ResultData selectResourceById(@PathVariable("id") Object id);
}

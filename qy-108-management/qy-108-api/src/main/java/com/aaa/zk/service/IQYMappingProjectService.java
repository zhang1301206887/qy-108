package com.aaa.zk.service;

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingProject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "mappingProject-interface")
public interface IQYMappingProjectService {
    /**
     * @author: gfq
     *  查询所有项目
     * @date: 20-05-25 13:59
     */
    @GetMapping("MappingProjectSelectAll")
    ResultData MappingProjectSelectAll();

    /**
     * @author: gfq
     *  新增项目
     * @date: 20-05-25 14:08
     */
    @PostMapping("MappingProjectAdd")
    ResultData MappingProjectAdd(@RequestBody MappingProject mappingProject);

    /**
     * @author: gfq
     * 按条件查询项目数据
     * @date: 20-05-25 14:08
     */
    @PostMapping("MappingProjectSelect")
    ResultData MappingProjectSelect(@RequestBody MappingProject mappingProject);

    /**
     * @author: gfq
     * 修改项目信息
     * @date: 20-05-25 14:10
     */
    @PostMapping("MappingProjectUpdate")
    ResultData MappingProjectUpdate(@RequestBody MappingProject mappingProject);

    /**
     * @author: gfq
     *  删除项目
     * @date: 20-05-25 14:12
     */
    @PostMapping("MappingProjectDelete")
    ResultData MappingProjectDelete(@RequestBody Object id);
}

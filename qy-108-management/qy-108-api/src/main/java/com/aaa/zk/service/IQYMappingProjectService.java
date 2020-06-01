package com.aaa.zk.service;

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingProject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient(value = "mappingProject-interface")
public interface IQYMappingProjectService {


    /**
     * @author zk
     * @Date
     *    根据项目成果汇交状态 查询 项目  0:通过 1:未通过 2:已提交 3:未提交
     */
    @GetMapping("/selectByResultsStatus")
    List<MappingProject> selectByResultsStatus(@RequestParam("resultsStatus")  Integer resultsStatus);

    /**
    * @author zk
    * @Date
    *  这个方法是根据userId、查询单位项目数量
    */
    @PostMapping("/selectProjectCountByUserId")
    Integer selectProjectCountByUserId(@RequestBody Object userId);

    /**
     * 这个方法是查询项目完成情况，用于统计图
     **/
    @GetMapping("/selectProjectType")
    List<Map> selectProjectType();


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

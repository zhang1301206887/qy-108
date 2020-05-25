package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingProject;
import com.aaa.zk.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MappingProjectController extends BaseController {

    @Autowired
    private MappingProjectService mappingProjectService;

    /**
     * @author: gfq
     *  查询所有项目
     * @date: 20-05-25 13:59
     */
    @GetMapping("MappingProjectSelectAll")
    public ResultData MappingProjectSelectAll(){
        List<MappingProject> mappingProjects = mappingProjectService.MappingProjectSelectAll();
        if (null != mappingProjects && !"".equals(mappingProjects)){
            return selelctSuccess(mappingProjects);
        }else {
            return selelctFalied();
        }
    }

    /**
     * @author: gfq
     *  新增项目
     * @date: 20-05-25 14:08
     */
    @PostMapping("MappingProjectAdd")
    public ResultData MappingProjectAdd(@RequestBody MappingProject mappingProject){
        Integer i = mappingProjectService.MappingProjectAdd(mappingProject);
        if (i > 0){
            return insertSuccess();
        }
        return insertFalied();
    }

    /**
     * @author: gfq
     * 按条件查询项目数据
     * @date: 20-05-25 14:08
     */
    @PostMapping("MappingProjectSelect")
     public ResultData MappingProjectSelect(@RequestBody MappingProject mappingProject){
         List<MappingProject> mappingProjects = mappingProjectService.MappingProjectSelect(mappingProject);
         // 判断查询到的数据是否为空
         if (null != mappingProjects && !"".equals(mappingProjects)){
             return selelctSuccess(mappingProjects);
         }else {
             return null;
         }
     }

     /**
      * @author: gfq
      * 修改项目信息
      * @date: 20-05-25 14:10
      */
     @PostMapping("MappingProjectUpdate")
     public ResultData MappingProjectUpdate(@RequestBody MappingProject mappingProject){
         Integer i = mappingProjectService.MappingProjectUpdate(mappingProject);
         if (i > 0){
             return updataSuccess();
         }
         return updateFalied();
     }
     /**
      * @author: gfq
      *  删除项目
      * @date: 20-05-25 14:12
      */
     @PostMapping("MappingProjectDelete")
     public ResultData MappingProjectDelete(@RequestBody Object id){
         Integer i = mappingProjectService.MappingProjectDelete(id);
         if (i > 0){
             return deleteSuccess();
         }
         return deleteFalied();
     }
}

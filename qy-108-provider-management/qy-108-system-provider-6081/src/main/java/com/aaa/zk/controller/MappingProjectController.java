package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingProject;
import com.aaa.zk.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MappingProjectController extends BaseController {

    @Autowired
    private MappingProjectService mappingProjectService;

    /**
     * @author zk
     * @Date
     *    根据项目成果汇交状态 查询 项目  0:通过 1:未通过 2:已提交 3:未提交
     */
    @GetMapping("/selectByResultsStatus")
    public List<MappingProject> selectByResultsStatus(@RequestParam("resultsStatus")  Integer resultsStatus){
        return mappingProjectService.selectByResultsStatus(resultsStatus);
    }

    /**
    * @author zk
    * @Date
    *   这个方法 是根据userId查询单位的项目数量
    */
    @PostMapping("/selectProjectCountByUserId")
    public Integer selectProjectCountByUserId(@RequestBody Object userId){
        return mappingProjectService.selectProjectCountByUserId(userId);
    }


    /**
    * @author zk
    * @Date
    *这个方法是查询项目完成情况
    */
    @GetMapping("/selectProjectType")
    public List<Map> selectProjectType(){

        return mappingProjectService.selectProjectType();

    }


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

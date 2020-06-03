package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.SpecialPost;
import com.aaa.zk.service.SpecialPostService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author zk
 * @Date 2020/5/25
 */
@RestController
public class SpecialPostController extends BaseController{

    @Autowired
    private SpecialPostService specialPostService;
    /**
    * @author zk
    * @Date
    * 根据userId查询公司特岗人员数量
    */
    @GetMapping("selectSpecialPostCount")
    public ResultData selectSpecialPostCount(@RequestParam("userId") Object userId){
        Integer i = specialPostService.selectSpecialPostCount(userId);
        if (i > 0){
            return selelctSuccess(i);
        }else{
            return selelctFalied();
        }
    }

    /**
     * @Author: He create on 2020/5/26 22:07
     * @param: [userId]
     * @return: java.util.List<com.aaa.zk.model.SpecialPost>
     * @Description: 根据公司id查询特殊岗位人员信息
     */
    @GetMapping("selectSpecialPostByUserId")
    public ResultData selectSpecialPostByUserId(@RequestParam("userId") Object userId,@RequestParam("pageNo") Integer pageNo,
                                                @RequestParam("pageSize") Integer pageSize){
        PageInfo<Map> mapPageInfo = specialPostService.selectSpecialPostByUserId(userId,pageNo,pageSize);
        if (null != mapPageInfo && !"".equals(mapPageInfo) ){
            return selelctSuccess(mapPageInfo);
        }
        return selelctFalied();
    }

    /**
     * @Author: He create on 2020/5/26 22:08
     * @param: [id]
     * @return: com.aaa.zk.model.SpecialPost
     * @Description: 根据主键id查询特殊岗位人员信息和对应的附件信息
     */
    @GetMapping("selectSpecialByPrimaryKey")
    public ResultData selectSpecialByPrimaryKey(@RequestParam("id") Object id){
        Map map = specialPostService.selectSpecialByPrimaryKey(id);
        if (null != map){
            return selelctSuccess(map);
        }
        return selelctFalied();
    }
    /**
     * @Author: He create on 2020/5/26 22:08
     * @param: [specialPost]
     * @return: java.lang.Integer
     * @Description: 添加特殊岗位人员信息
     */
    @PutMapping("insertSpecial")
    public ResultData insertSpecial(@RequestBody SpecialPost specialPost){
        Integer integer = specialPostService.insertSpecial(specialPost);
        if (integer > 0){
            return insertSuccess();
        }
        return insertFalied();
    }
    /**
     * @Author: He create on 2020/5/26 22:08
     * @param: [specialPost]
     * @return: java.lang.Integer
     * @Description: 根据主键id更新特殊岗位人员信息
     */
    @PostMapping("updateSpecialByPrimaryKey")
    public ResultData updateSpecialByPrimaryKey(@RequestBody SpecialPost specialPost){
        Integer updateSpecialByPrimaryKey = specialPostService.updateSpecialByPrimaryKey(specialPost);
        if (updateSpecialByPrimaryKey > 0){
            return updataSuccess();
        }
        return updateFalied();
    }
    /**
     * @Author: He create on 2020/5/26 22:08
     * @param: [id]
     * @return: java.lang.Integer
     * @Description: 根据主键id删除特殊岗位人员信息
     */
    @DeleteMapping("deleteSpecialByPrimaryKey")
    public ResultData deleteSpecialByPrimaryKey(@RequestParam("id") Object id){
        Integer deleteSpecialByPrimaryKey = specialPostService.deleteSpecialByPrimaryKey(id);
        if (deleteSpecialByPrimaryKey > 0){
            return deleteSuccess();
        }
        return deleteFalied();
    }
}

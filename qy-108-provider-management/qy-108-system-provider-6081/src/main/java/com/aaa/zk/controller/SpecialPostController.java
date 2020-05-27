package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.SpecialPost;
import com.aaa.zk.service.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("selectSpecialPostCount/{userId}")
    public ResultData selectSpecialPostCount(@PathVariable("userId") Object userId){
        System.out.println(userId);
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
    @GetMapping("selectSpecialPostByUserId/{userId}")
    public ResultData selectSpecialPostByUserId(@PathVariable("userId") Object userId){
        System.out.println(userId);
        List<SpecialPost> specialPosts = specialPostService.selectSpecialPostByUserId(userId);
        if (null != specialPosts){
            return selelctSuccess(specialPosts);
        }
        return selelctFalied();
    }

    /**
     * @Author: He create on 2020/5/26 22:08
     * @param: [id]
     * @return: com.aaa.zk.model.SpecialPost
     * @Description: 根据主键id查询特殊岗位人员信息
     */
    @GetMapping("selectSpecialByPrimaryKey/{id}")
    public ResultData selectSpecialByPrimaryKey(@PathVariable("id") Object id){
        SpecialPost specialPost = specialPostService.selectSpecialByPrimaryKey(id);
        if (null != specialPost){
            return selelctSuccess(specialPost);
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
    @DeleteMapping("deleteSpecialByPrimaryKey/{id}")
    public ResultData deleteSpecialByPrimaryKey(@PathVariable("id") Object id){
        Integer deleteSpecialByPrimaryKey = specialPostService.deleteSpecialByPrimaryKey(id);
        if (deleteSpecialByPrimaryKey > 0){
            return deleteSuccess();
        }
        return deleteFalied();
    }
}

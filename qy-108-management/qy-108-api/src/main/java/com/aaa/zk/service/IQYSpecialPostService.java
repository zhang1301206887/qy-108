package com.aaa.zk.service;

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.SpecialPost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author zk
 * @Date 2020/5/25
 */
@FeignClient(value = "specialPost-interface")
public interface IQYSpecialPostService {
    /**
    * @author zk
    * @Date
    *   根据userId查询特岗员工数量
    */
    @GetMapping("selectSpecialPostCount")
    public ResultData selectSpecialPostCount(@RequestParam("userId") Object userId);

    /**
     * @Author: He create on 2020/5/26 22:07
     * @param: [userId]
     * @return: java.util.List<com.aaa.zk.model.SpecialPost>
     * @Description: 根据公司id查询特殊岗位人员信息
     */
    @GetMapping("selectSpecialPostByUserId")
    public ResultData selectSpecialPostByUserId(@RequestParam("userId") Object userId,@RequestParam("pageNo") Integer pageNo,
                                                @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author: He create on 2020/5/26 22:08
     * @param: [id]
     * @return: com.aaa.zk.model.SpecialPost
     * @Description: 根据主键id查询特殊岗位人员信息
     */
    @GetMapping("selectSpecialByPrimaryKey")
    public ResultData selectSpecialByPrimaryKey(@RequestParam("id") Object id);

    /**
     * @Author: He create on 2020/5/26 22:08
     * @param: [specialPost]
     * @return: java.lang.Integer
     * @Description: 添加特殊岗位人员信息
     */
    @PutMapping("insertSpecial")
    public ResultData insertSpecial(@RequestBody SpecialPost specialPost);

    /**
     * @Author: He create on 2020/5/26 22:08
     * @param: [specialPost]
     * @return: java.lang.Integer
     * @Description: 根据主键id更新特殊岗位人员信息
     */
    @PostMapping("updateSpecialByPrimaryKey")
    public ResultData updateSpecialByPrimaryKey(@RequestBody SpecialPost specialPost);

    /**
     * @Author: He create on 2020/5/26 22:08
     * @param: [id]
     * @return: java.lang.Integer
     * @Description: 根据主键id删除特殊岗位人员信息
     */
    @DeleteMapping("deleteSpecialByPrimaryKey")
    public ResultData deleteSpecialByPrimaryKey(@RequestParam("id") Object id);

}

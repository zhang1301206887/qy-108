package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/28 19:54
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Score;
import com.aaa.zk.service.IQYScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "分值信息", tags = "分值信息管理")
public class ScoreController extends BaseController {
    @Autowired
    private IQYScoreService scoreService;
    /**
     * @Author: He create on 2020/5/28 19:52
     * @param: [userId]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据单位id查询所有的分值记录
     */
    @GetMapping("selectScoreByUserId/{userId}")
    @ApiOperation(value = "查询功能",notes = "根据单位id查询具体的分值记录")
    public ResultData selectScoreByUserId(@PathVariable("userId") Object userId){
        return scoreService.selectScoreByUserId(userId);
    }
    /**
     * @Author: He create on 2020/5/28 19:53
     * @param: [score]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 添加新的分值记录
     */
    @PutMapping("insertScore")
    @ApiOperation(value = "添加功能",notes = "添加新分值数据")
    public ResultData insertScore(@RequestBody Score score){
        return scoreService.insertScore(score);
    }
}

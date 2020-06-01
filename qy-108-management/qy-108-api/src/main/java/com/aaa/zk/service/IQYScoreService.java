package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/28 19:51
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Score;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("score-interface")
public interface IQYScoreService {
    /**
     * @Author: He create on 2020/5/28 19:52
     * @param: [userId]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据单位id查询所有的分值记录
     */
    @GetMapping("selectScoreByUserId")
    public ResultData selectScoreByUserId(@RequestParam("userId") Object userId);
    /**
     * @Author: He create on 2020/5/28 19:53
     * @param: [score]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 添加新的分值记录
     */
    @PutMapping("insertScore")
    public ResultData insertScore(@RequestBody Score score);
}

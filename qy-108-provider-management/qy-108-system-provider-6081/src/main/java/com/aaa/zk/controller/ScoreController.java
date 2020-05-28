package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/28 11:12
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.CommonController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.MappingUnit;
import com.aaa.zk.model.Score;
import com.aaa.zk.service.MappingUnitService;
import com.aaa.zk.service.ScoreService;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController extends CommonController<Score> {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private MappingUnitService mappingUnitService;

    public BaseService<Score> getBaseService() {
        return scoreService;
    }
    @GetMapping("selectScoreByUserId/{userId}")
    public ResultData selectScoreByUserId(@PathVariable("userId") Object userId)  {
        Score score = new Score().setUnitId(Long.valueOf(userId.toString()));
        List<Score> scores = null;
        try {
            scores = scoreService.queryList(score);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != scores && scores.size() > 0){
            return selelctSuccess(scores);
        }
        return selelctFalied();
    }
    @PutMapping("insertScore")
    public ResultData insertScore(@RequestBody Score score){
        try {
            //自动获取id进行添加数据
            score.setId(IDUtils.getID()).setCreateTime(DateUtils.getCurrentDate());
            //获取前台传入的数据是加分还是减分操作 进行对数据库用户分值的具体操作
            Integer scorePlus = score.getScorePlus();
            Integer scoreSubtract = score.getScoreSubtract();
            //将前台传入的关联id绑定到实体类中进行下一步对单位分值的操作
            MappingUnit mappingUnit = new MappingUnit().setId(score.getUnitId());
            //定义一个对表score操作的返回值
            Integer insertResult = 0;
            if (scorePlus != null){
                //证明是加分操作
                mappingUnit.setScore(scorePlus);
                Integer integer = mappingUnitService.updateInsertScoreById(mappingUnit);
                //当对单位表操作成功是再对分值表进行操作
                if (integer > 0){
                    insertResult = scoreService.add(score);
                    // 证明添加数据成功
                    if (insertResult > 0){
                        return insertSuccess();
                    }
                    return insertFalied();
                }
            }else {
                //证明是减分操作
                mappingUnit.setScore(scoreSubtract);
                Integer integer = mappingUnitService.updateDeleteScoreById(mappingUnit);
                //同上
                if (integer > 0){
                    insertResult = scoreService.add(score);
                    if (insertResult > 0){
                        return insertSuccess();
                    }
                    return insertFalied();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return insertFalied();
    }
}

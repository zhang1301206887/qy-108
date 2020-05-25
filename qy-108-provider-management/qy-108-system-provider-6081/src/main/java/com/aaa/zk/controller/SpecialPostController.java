package com.aaa.zk.controller;

import com.aaa.zk.base.BaseController;
import com.aaa.zk.mapper.SpecialPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zk
 * @Date 2020/5/25
 */
@RestController
public class SpecialPostController {

    @Autowired
    private SpecialPostMapper specialPostMapper;

    @PostMapping("/selectSpecialPostCount")
    public Integer selectSpecialPostCount(@RequestBody Object userId){
        Integer i = specialPostMapper.selectSpecialPostCount(userId);

        if (i > 0){
            return i;
        }else{
            return 0;
        }
    }

}

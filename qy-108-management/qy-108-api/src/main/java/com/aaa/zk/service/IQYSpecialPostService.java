package com.aaa.zk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
    @PostMapping("/selectSpecialPostCount")
    Integer selectSpecialPostCount(@RequestBody Object userId);

}

package com.aaa.zk.service;

import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zk
 * @Date 2020/5/29
 */
@FeignClient(value = "resource-interface")
public interface IQYResourceService {

    /**
     * @author zk
     * @Date
     *       根据项目id查询附件材料
     */
    @GetMapping("selectResourceByRefBizId")
    List<Resource> selectResourceByRefBizId(@RequestParam("id") Object id);
    /**
     * @Author: He create on 2020/6/3 20:48
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据附件的id查询附件信息
     */
    @GetMapping("selectResourceByPrimaryKey")
    public ResultData selectResourceByPrimaryKey(@RequestParam("id") Object id);
    /**
     * @Author: He create on 2020/5/29 22:24
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据单位id查询资源信息 选择展示
     */
    @GetMapping("selectResourceById")
    public ResultData selectResourceById(@RequestParam("id") Object id);
    /**
     * @Author: He create on 2020/5/29 22:25
     * @param: [resource]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 修改附件信息
     */
    @PostMapping("updateResourceById")
    public ResultData updateResourceById(@RequestBody Resource resource);
    /**
     * @Author: He create on 2020/5/30 23:06
     * @param: [resource]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 添加新的附件信息
     */
    @PutMapping("insertResource")
    public ResultData insertResource(@RequestBody Resource resource);

}

package com.aaa.zk.controller;
/**
 *@Company：
 *@Author：何康
 *@Date：2020/5/29 21:38
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.CommonController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Resource;
import com.aaa.zk.service.ResourceService;
import com.aaa.zk.utils.Map2BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ResourceController extends CommonController<Resource> {
    @Autowired
    private ResourceService resourceService;

    public BaseService<Resource> getBaseService() {
        return resourceService;
    }
    /**
     * @Author: He create on 2020/5/29 22:24
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据单位id查询资源信息 选择展示
     */
    @GetMapping("selectResourceById/{id}")
    public ResultData selectResourceById(@PathVariable("id") Object id){
        try {
            Resource resource = new Resource().setRefBizId(Long.valueOf(id.toString()));
            List<Resource> resources = resourceService.queryList(resource);
            if (null != resources && resources.size() > 0){
                return selelctSuccess(resources);
            }
            return selelctFalied();
        }catch (Exception e){
            e.printStackTrace();
        }
        return selelctFalied();
    }
    /**
     * @Author: He create on 2020/5/29 22:25
     * @param: [resource]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 修改信息
     */
    @PostMapping("updateResourceById")
    public ResultData updateResourceById(@RequestBody List<Map> list){
        try {
            Integer i = 0;
            //前台传入的是多个附件信息 进行循环遍历
            for (Map map : list){
                Integer a = i++;
                System.out.println("第"+ a +"次");
                //将list中的map转化为实体类进行 操作
                Resource resource = Map2BeanUtils.map2Bean(map, Resource.class);
                //判断表中是否存在该信息
                Resource selectResult = resourceService.selectResourceByIdAndType(map);
                if (null == selectResult){
                    //存在 即是修改信息
                    Integer add = resourceService.add(resource);
                    if (add > 0){
                        return updataSuccess();
                    }else {
                        return updateFalied();
                    }
                }else {
                    //不存在 添加新的信息
                    Integer update = resourceService.update(resource);
                    if (update > 0){
                        return updataSuccess();
                    }else {
                        return updateFalied();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateFalied();
    }
    /**
    * @Author: He create on 2020/5/30 23:06
    * @param: [resource]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加新的附件信息
    */
    @PutMapping("insertResource")
    public ResultData insertResource(@RequestBody Resource resource){
        try {
            Integer add = resourceService.add(resource);
            if (add > 0){
                 insertSuccess();
            }
            return insertFalied();
        }catch (Exception e){
            e.printStackTrace();
        }
        return insertFalied();
    }
    /**
     * @author zk
     * @Date
     *       根据 项目id查询 附件材料
     */
    @GetMapping("selectResourceByRefBizId/{id}")
    public List<Resource> selectResourceByRefBizId(@PathVariable("id") Object id){
        return resourceService.selectResourceByRefBizId(id);
    }
}

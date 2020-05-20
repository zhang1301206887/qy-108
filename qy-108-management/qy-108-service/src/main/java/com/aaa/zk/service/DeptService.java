package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/20 17:30
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.mapper.DeptMapper;
import com.aaa.zk.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService extends BaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;

    /**
    * @Author: He create on 2020/5/20 18:04
    * @param: []
    * @return: java.util.List<com.aaa.zk.model.Dept>
    * @Description: 查询所有部门信息
    */
    public List<Dept> selectAll(){
        List<Dept> depts = deptMapper.selectAll();
        if (null != depts && depts.size()>0){
           return depts;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/20 17:49
    * @param: [dept]
    * @return: com.aaa.zk.model.Dept
    * @Description: 根据部门名称查询部门的基本信息
    */
    public Dept selectByName(Dept dept){
        Dept dept1 = deptMapper.selectOne(dept);
        if (null != dept1 && "".equals(dept1)){
            return dept1;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/20 17:55
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 新增部门
    */
    public Integer insert(Dept dept){
        int insertResult = deptMapper.insert(dept);
        if (insertResult > 0){
            return insertResult;
        }
        return 0;
    }
    /**
    * @Author: He create on 2020/5/20 18:00
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 根据主键id 修改部门信息
    */
    public Integer updateByPrimaryKey(Dept dept){
        int updateResult = deptMapper.updateByPrimaryKey(dept);
        if (updateResult > 0){
            return updateResult;
        }
        return 0;
    }
    /**
    * @Author: He create on 2020/5/20 18:00
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 根据主键id 删除部门
    */
    public Integer deleteByPrimaryKey(Dept dept){
        int deleteResult = deptMapper.deleteByPrimaryKey(dept);
        if (deleteResult > 0){
            return deleteResult;
        }
        return 0;
    }
}

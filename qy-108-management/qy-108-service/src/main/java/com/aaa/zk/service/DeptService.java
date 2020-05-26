package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/20 17:30
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.DeptMapper;
import com.aaa.zk.model.Dept;
import com.aaa.zk.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.aaa.zk.status.CURDStatus.CRUD_FALIED;

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
    public List<Dept> selectAllDept(){
        List<Dept> depts = deptMapper.selectAll();
        if (null != depts && depts.size()>0){
           return depts;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/26 14:23
    * @param: [id]
    * @return: com.aaa.zk.model.Dept
    * @Description: 根据主键查询信息
    */
    public Dept selectDeptByPrimaryKey(Object id){
        if (null != id){
            Dept dept = deptMapper.selectByPrimaryKey(id);
            if (null != dept){
                return dept;
            }
            return null;
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/20 17:49
    * @param: [dept]
    * @return: com.aaa.zk.model.Dept
    * @Description: 根据部门名称查询部门的基本信息
    */
    public List<Dept> selectDeptByName(Dept dept){
        if (null != dept){
            List<Dept> select = deptMapper.select(dept);
            if (null != select && select.size()>0){
                return select;
            }
        }
        return null;
    }
    /**
    * @Author: He create on 2020/5/20 17:55
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 新增部门
    */
    public Integer insertDept(Dept dept){
        if (null != dept){
            //使用工具类获取当前时间转化为string类型
            dept.setCreateTime(new DateUtil().getNowDate());
            int insertResult = deptMapper.insert(dept);
            if (insertResult > 0){
                return insertResult;
            }
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/20 18:00
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 根据主键id 修改部门信息
    */
    public Integer updateDeptByPrimaryKey(Dept dept){
        if (null != dept){
            dept.setModifyTime(new DateUtil().getNowDate());
            int updateResult = deptMapper.updateByPrimaryKey(dept);
            if (updateResult > 0){
                return updateResult;
            }
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/20 18:00
    * @param: [dept]
    * @return: java.lang.Integer
    * @Description: 根据主键id 删除部门
    */
    public Integer deleteDeptByPrimaryKey(Object deptId){
        if (null != deptId){
            int deleteResult = deptMapper.deleteByPrimaryKey(deptId);
            if (deleteResult > 0){
                return deleteResult;
            }
        }
        return CRUD_FALIED;
    }
    /**
    * @Author: He create on 2020/5/21 23:07
    * @param: [map]
    * @return: java.lang.Integer
    * @Description: 通过主键id批量删除数据
    */
    public Integer deleteDeptByPrimaryKeyList(List<Map> list){
        if (null != list && list.size()>0){
            Integer deleteNum = 0;
            //循环遍历list中的map 取出其中的id进行删除操作
            for (Map map : list){
                Object id = map.get("id");
                int deleteResult = deptMapper.deleteByPrimaryKey(id);
                if (deleteResult > 0){
                    deleteNum += 1;
                }
            }
            return deleteNum;
        }
       return CRUD_FALIED;
    }
}

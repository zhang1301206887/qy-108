package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/20 17:30
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.DeptMapper;
import com.aaa.zk.model.Dept;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.vo.DeptVo;
import com.aaa.zk.vo.MenuVo;
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
    public List<DeptVo> selectAllDept(Object id){
        //第一次查询传入的id为0 则为查询所有的菜单表
        List<DeptVo> deptVos = deptMapper.selectAllDept(id);
        if (null != deptVos && deptVos.size() > 0){
            //循环遍历第一次查询的集合
            for (DeptVo deptVo : deptVos) {
                //以本身的id为参数  进行查询本身的子菜单
                Object id1 = deptVo.getId();
                //循环查询 直到本身菜单不在存在子菜单
                List<DeptVo> deptVos1 = this.selectAllDept(id1);
                //添加到父级菜单的集合中 进行数据的返回
                deptVo.setChildrenList(deptVos1);
            }
            return deptVos;
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
    public List<Dept> selectDeptByField(Map map){
        if (null != map){
            List<Dept> select = deptMapper.selectDeptByField(map);
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
            dept.setCreateTime(DateUtils.getCurrentDate());
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
            dept.setModifyTime(DateUtils.getCurrentDate());
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
            Integer integer = deptMapper.deleteDeptByParentId(deptId);
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
                Integer integer = deptMapper.deleteDeptByParentId(id);
                if (deleteResult > 0){
                    deleteNum += 1;
                }
            }
            return deleteNum;
        }
       return CRUD_FALIED;
    }
}

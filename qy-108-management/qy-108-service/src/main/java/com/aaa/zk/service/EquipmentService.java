package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/26 16:29
 *@Description:
 */

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.EquipmentMapper;
import com.aaa.zk.model.Equipment;
import com.aaa.zk.model.Resource;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.aaa.zk.status.CURDStatus.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentService extends BaseService<Equipment> {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * @Author: He create on 2020/5/26 16:56
     * @param: [userId]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据公司id查询设备信息
     */
    public PageInfo<Equipment> selectEquiByUserId(Object userId,Integer pageNo,Integer pageSize){
        if (null != userId && !"".equals(userId)){
            //封装进pagehelper
            PageHelper.startPage(pageNo,pageSize);
            List<Equipment> equipment = equipmentMapper.selectEquiByUserId(userId);
            if (null != equipment && equipment.size() > 0){
                PageInfo<Equipment> pageInfo = new PageInfo<Equipment>(equipment);
                return pageInfo;
            }
            return null;
        }
        return null;
    }
    /**
     * @Author: He create on 2020/5/26 16:55
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id查询设备信息
     */
    public Map selectEquiByPrimaryKey(Object id){
        if (null != id){
            Map map = new HashMap();
            Equipment equipment = equipmentMapper.selectByPrimaryKey(id);
            List<Resource> resources = equipmentMapper.selectResourceById(id);
            if (null != equipment){
                map.put("equipment",equipment);
                if (null != resources && resources.size() > 0){
                    map.put("resources",resources);
                    return map;
                }
                return map;
            }
            return null;
        }
        return null;
    }
    /**
     * @Author: He create on 2020/5/26 16:55
     * @param: [equipment]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 添加新设备信息
     */
    public Integer insertEqui(Equipment equipment){
        if (null != equipment){
            equipment.setId(IDUtils.getID());
            equipment.setCreateTime(DateUtils.getCurrentDate());
            int insert = equipmentMapper.insert(equipment);
            if (insert > 0){
                return insert;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
    /**
     * @Author: He create on 2020/5/26 16:55
     * @param: [equipment]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id更新设备信息
     */
    public Integer updateEquiByPrimaryKey(Equipment equipment){
        if (null != equipment){
            equipment.setModifyTime(DateUtils.getCurrentDate());
            int update = equipmentMapper.updateByPrimaryKey(equipment);
            if (update > 0){
                return update;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
    /**
     * @Author: He create on 2020/5/26 16:54
     * @param: [id]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据主键id删除设备数据
     */
    public Integer deleteEquiByPrimaryKey(Object id){
        if (null != id){
            int delete = equipmentMapper.deleteByPrimaryKey(id);
            if (delete > 0){
                return delete;
            }
            return CRUD_FALIED;
        }
        return CRUD_FALIED;
    }
}

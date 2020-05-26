package com.aaa.zk.controller;
/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/21 16:59
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Menu;
import com.aaa.zk.service.MenuService;
import com.aaa.zk.utils.DateUtil;
import com.aaa.zk.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    private String nowDate = new DateUtil().getNowDate();
    /**
    * @Author: He create on 2020/5/21 17:02
    * @param: [menu]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 查询一个菜单的具体信息
    */
    @PostMapping("selectMenuByField")
    public ResultData selectMenuByField(@RequestBody Menu menu){
        List<Menu> menus = menuService.selectMenuByField(menu);
        if (null != menus){
            return selelctSuccess(menus);
        }
        return selelctFalied();
    }

    /**
    * @Author: He create on 2020/5/26 14:45
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id查询菜单信息
    */
    @GetMapping("selectMenuByPrimaryKey/{id}")
    public ResultData selectMenuByPrimaryKey(@PathVariable("id") Object id){
        Menu menu = menuService.selectMenuByPrimaryKey(id);
        if (null != menu){
            return selelctSuccess(menu);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/21 17:01
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 遍历查询所有的权限菜单
    */
    @GetMapping("selectMenuByParentId/{id}")
    public ResultData selectMenuByParentId(@PathVariable("id") Object id){
        List<MenuVo> menuVos = menuService.selectMenuByParentId(id);
        if (null != menuVos){
            return selelctSuccess(menuVos);
        }
        return selelctFalied();
    }
    /**
    * @Author: He create on 2020/5/21 18:15
    * @param: [menu]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加菜单
    */
    @PutMapping("insertMenu")
    public ResultData insertMenu(@RequestBody Menu menu){
        Integer insertResult = menuService.insertMenu(menu);
        if (insertResult > 0 ){
            return insertSuccess();
        }
        return insertFalied();
    }
    /**
    * @Author: He create on 2020/5/21 18:15
    * @param: [menu]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id 进行菜单数据的更新
    */
    @PostMapping("updateMenuByPrimaryKey")
    public ResultData updateByPrimaryKey(@RequestBody Menu menu){
        menu.setCreateTime(nowDate);
        Integer updateResult = menuService.updateMenuByPrimaryKey(menu);
        if (updateResult > 0 ){
            return updataSuccess();
        }
        return updateFalied();
    }
    /**
    * @Author: He create on 2020/5/21 18:15
    * @param: [id]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 根据主键id删除菜单数据
    */
    @DeleteMapping("deleteMenuByPrimaryKey")
    public ResultData deleteMenuByPrimaryKey(@RequestBody Object id){
        Integer deleteResult = menuService.deleteMenuByPrimaryKey(id);
        if (deleteResult > 0 ){
            return deleteSuccess();
        }
        return deleteFalied();
    }
    /**
     * @Author: He create on 2020/5/21 23:25
     * @param: [list]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 根据前台传入的list  遍历map id 进行删除操作
     */
    @DeleteMapping("deleteMenuByPrimaryKeyList")
    public ResultData deleteDeptByPrimaryKeyList(@RequestBody List<Map> list){
        Integer integer = menuService.deleteMenuByPrimaryKeyList(list);
        if (integer > 0){
            return deleteSuccess("删除成功，共"+integer+"数据！");
        }
        return deleteFalied();
    }
}

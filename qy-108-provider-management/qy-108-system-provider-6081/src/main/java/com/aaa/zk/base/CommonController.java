package com.aaa.zk.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class CommonController<T> extends BaseController {

    /**
     *      钩子函数，在新增之前所执行的内容
    **/
    protected void beforeAdd(Map map) {
        // TODO 钩子函数，也就是说如果在插入之前你需要执行某些业务的时候，则需要编写内容
    }

    /**
     *      钩子函数，在新增之后所执行的内容
    **/
    protected void afterAdd(Map map) {
        // TODO 钩子函数，也就是说如果在插入之后你需要执行某些业务的时候，则需要编写内容
    }

    public abstract BaseService<T> getBaseService();



    /**
     *      新增数据
     *      * 钩子函数  比如order表   orderitem表  你必须先存order获取orderid后在根据orderid去存orderitem表
     *      * 所以beforeAdd  就是order的业务获取orderid的   afterAdd存orderitem表
    **/
    public ResultData add(@RequestBody Map map) {
        ResultData resultData = new ResultData();
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            Integer insertResult = getBaseService().add(instance);
            if(insertResult > 0) {
                // 说明保存成功
                afterAdd(map);
                return loginSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginFailed();
    }
    /**
     * 删除数据
     * @param map
     * @return
     */
    public ResultData delete(@RequestBody Map map){
        ResultData resultData = new ResultData();
        T instance = getBaseService().newInstance(map);
        try {
            Integer i = getBaseService().delete(instance);
            if (i>0){
                return delete();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return deleteNot();

    }
    /**
     * 批量删除数据
     * @param map
     * @return
     */
    public ResultData batchDelete(@RequestBody Map map){
        ResultData resultData = new ResultData();
        T instance = getBaseService().newInstance(map);
        ArrayList<Object> list = new ArrayList();
        list.add(instance);
        try {
            Integer i = getBaseService().delete(list);
            if (i>0){
                return delete();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return deleteNot();

    }

    /**
     * 修改数据
     * @param map
     * @return
     */
    public ResultData upDate(@RequestBody Map map){
        ResultData resultData = new ResultData();
        T instance = getBaseService().newInstance(map);
        try {
            Integer i = getBaseService().update(instance);
            if (i>0){
                return updata();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return updateNot();

    }

    /**
     * 查询一条数据
     * @param map
     * @return
     */
    public ResultData getOne(@RequestBody Map map){
        ResultData resultData = new ResultData();
        T instance = getBaseService().newInstance(map);
        try {
            Map map1 = (Map) getBaseService().queryOne(instance);
            if (map1 != null && !"".equals(map1)){
                resultData.setData(map1);
                return selelct(resultData);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return selelctNot();

    }
    /**
     * 查询多条数据
     * @param map
     * @return
     */

    public ResultData getList(@RequestBody Map map){
        ResultData resultData = new ResultData();
        T instance = getBaseService().newInstance(map);
        try {
            List<T> tList = getBaseService().queryList(instance);
            if (tList.size()>0 && !"".equals(tList)){
                resultData.setData(tList);
                return selelct(resultData);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return selelctNot();

    }

    /**
     * 分页数据
     * @param map
     * @return
     */
    public ResultData getListByPage(@RequestBody Map map){
        ResultData resultData = new ResultData();
        T instance = getBaseService().newInstance(map);
        try {
            PageInfo<T> tPageInfo = getBaseService().queryListByPage(instance, 5, 5);
            resultData.setData(tPageInfo);
            return pageInfo(resultData);
        }catch(Exception e){
            e.printStackTrace();
        }
        return pageInfoNot();

    }
    // TODO delete, batchDelete, update, getOne, getList, getListByPage(不带条件的分页查询)

    /**
     *      防止数据不安全，所以不能直接在controller某个方法中直接接收HttpServletRequest对象
     *      必须要从本地当前线程中获取对象
    **/
    public HttpServletRequest getServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if(requestAttributes instanceof ServletRequestAttributes) {
            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }

    /**
     *      获取当前客户端的session对象(如果不存在，则会重新创建一个)
    **/
    public HttpSession getSession() {
        return getServletRequest().getSession();
    }

    /**
     *      获取当前客户端的session对象(如果不存在，则直接返回为null)
    **/
    public HttpSession getExistSession() {
        return getServletRequest().getSession(false);

    }


}

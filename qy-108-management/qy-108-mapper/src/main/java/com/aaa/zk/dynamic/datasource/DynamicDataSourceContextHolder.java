package com.aaa.zk.dynamic.datasource;



import com.aaa.zk.utils.StringUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;

import java.util.Deque;
import java.util.List;

/**
* @Author: He create on 2020/5/30 19:13
* @param:
* @return:
* @Description: 创建动态数据源上下文的一个操作对象
 *  *      (其实它就是一个所给用户提供的API工具类)
*/
public class DynamicDataSourceContextHolder {

    private DynamicDataSourceContextHolder() {

    }
    // 设置一个变量，存放当前正在运行线程的数据源信息
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();
    // 存放数据源的id
    public static List<String> dataSourceIds = new ArrayList<String>();

    /**
    * @Author: He create on 2020/5/30 19:13
    * @param: [datasourceType]
    * @return: void
    * @Description: 设置选择数据源的类型
    */
    public static void setDatasourceType(String datasourceType) {
        CONTEXT_HOLDER.set(datasourceType);
    }

    /**
    * @Author: He create on 2020/5/30 19:13
    * @param: []
    * @return: java.lang.String
    * @Description: 获取当前的数据源 如果没有使用默认的
    */
    public static String getDataSourceType() {
        return CONTEXT_HOLDER.get();
    }

   /**
   * @Author: He create on 2020/5/30 19:12
   * @param: []
   * @return: void
   * @Description: 清空数据源
   */
    public static void clearDataSouceType() {
        CONTEXT_HOLDER.remove();
    }

    /**
    * @Author: He create on 2020/5/30 19:12
    * @param: [dataSourceId]
    * @return: java.lang.Boolean
    * @Description: 判断当前数据源是否存在
    */
    public static Boolean isContainsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }

    /**
     * @author Seven Lee
     * @description
     *      防止数据源切换的时候造成混乱
     *          使用链表的优势就在于可以直接从栈中把数据源查出来，防止数据源切换的时候混乱
     *      eg:
     *          现在有A，B，C这三个service层
     *          而且这三个service使用都是不同的数据源
     *          但是问题来了:
     *              AService里面某一个方法调用BService中的方法，恰巧BService的这个方法又需要
     *              去调用CService
     *                  这么一来就一级一级的来切换，最终形成了链条
     *              传统的多数据源切换只能设置到当前线程(也就是说这一个线程只能使用一个事务)
     *              不能满足当前业务需求
     *              所以必须要去模拟JVM的栈操作(栈有一个规则:后进先出，所以就防止了在一个线程中
     *              多次切换数据源的实话发生混乱)
     *
     *        ArrayDeque:
     *          数组的双向队列(特点就是没有容量的限制可以无限扩容)
     * @param
     * @date 2020/5/30
     * @return
     * @throws
    **/
    public static final ThreadLocal<Deque<String>> LOOKUP_KEY_HOLDER = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new ArrayDeque();
        }
    };


    /**
    * @Author: He create on 2020/5/30 19:12
    * @param: []
    * @return: java.lang.String
    * @Description: 获取当前线程的数据源
    */
    public static String peek() {
        return LOOKUP_KEY_HOLDER.get().peek();
    }


    /**
    * @Author: He create on 2020/5/30 19:08
    * @param: [dataSource]
    * @return: void
    * @Description: 设置当前线程使用的数据源
     *  不是必须使用的话 不要轻易使用 如果使用该方法一起要清理垃圾数据
     *  否则会造成非常大量的内存占用 拉低效率
    */
    public static void push(String dataSource) {
        LOOKUP_KEY_HOLDER.get().push(StringUtils.isEmpty(dataSource) ? "" :dataSource);
    }

    /**
    * @Author: He create on 2020/5/30 19:10
    * @param: []
    * @return: void
    * @Description: 清空方法  清空当前线程的数据源
    */
    public static void poll() {
        Deque<String> deque = LOOKUP_KEY_HOLDER.get();
        deque.poll();// 失败了
        if(deque.isEmpty()) {
            LOOKUP_KEY_HOLDER.remove();
        }
    }

    /**
    * @Author: He create on 2020/5/30 19:11
    * @param: []
    * @return: void
    * @Description: 强制清空本地线程的数据源  如果调用了push方法时  一定要调用这个方法清空
    */
    public static void clear() {
        LOOKUP_KEY_HOLDER.remove();
    }

}

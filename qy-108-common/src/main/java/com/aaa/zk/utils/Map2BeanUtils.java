package com.aaa.zk.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zk
 * @Date 2020/5/12
 */
public class Map2BeanUtils {

    private Map2BeanUtils() {

    }
    // 使用高性能java实例化工具
    private final static Objenesis OBJENESIS = new ObjenesisStd(true);
    // StringBuffer的性能虽然次于StringBuilder，但是StringBuilder是线程安全的
    private final static StringBuffer STRING_BUFFER = new StringBuffer();
    // 使用Map集合作用本地缓存池来使用(也必须要保证线程安全)
    private final static ConcurrentHashMap<Class, MethodAccess> CONCURRENT_HASH_MAP =
            new ConcurrentHashMap<Class, MethodAccess>();


    public static <T> T map2Bean(Map<String, Object> map,Class<T> clazz){
        T instance = OBJENESIS.newInstance(clazz);
        MethodAccess methodAccess = CONCURRENT_HASH_MAP.get(clazz);
        /**
         * Map中是以key和value存在的
         * map.put("username", "zhangsan");
         * map.put("username", "lisi");--->lisi就把zhangsan覆盖了
         * map.putIfAbsent("username", "wangwu");--->wangwu并不会存放，因为username这个key已经存在
         */
        // 就是为了获取下一步的get和set方法

        CONCURRENT_HASH_MAP.putIfAbsent(clazz,methodAccess);
        for (Map.Entry<String , Object> entry : map.entrySet()){
            String setMethodName = setMethodName(entry.getKey());
            int index = methodAccess.getIndex(setMethodName,entry.getValue().getClass());
            methodAccess.invoke(instance,index,entry.getValue());
        }
        return instance;

    }
    private static String setMethodName(String fieldName) {

        // fieldName--->bookName--->getBookName()
        // 所以第一步并不是直接获取，而是先把这个字段的首字母大写
        String filedJava = firstToUpperCase(fieldName);
        STRING_BUFFER.setLength(0);// 确保了StringBuffer中没有任何数据
        // 拼接set方法
        return STRING_BUFFER.append("set").append(filedJava).toString();
    }

    private static String firstToUpperCase(String field) {
        return field.substring(0,1).toUpperCase() + field.substring(1);
    }


}

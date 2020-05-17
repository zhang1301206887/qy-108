package com.aaa.zk.utils;

import java.util.UUID;

/**
 * @Author zk
 * @Date 2020/5/17
 */
public class IDUtils {
    private IDUtils(){

    }
    /**
     * 获取uuid
     *
     * */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}

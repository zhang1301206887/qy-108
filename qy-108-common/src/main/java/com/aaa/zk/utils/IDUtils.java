package com.aaa.zk.utils;

import java.text.SimpleDateFormat;
import java.util.Random;
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
    /**
    * @Author: He create on 2020/5/24 22:12
    * @param: []
    * @return: java.lang.Long
    * @Description: 自动生成id
    */
    public static  int ID=100;
    public static Long getID() {
        IDUtils.ID+=1;
        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        //获取时间戳
        String time=dateFormat.format(now);
        String info=now+"";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        int ran=0;
        if(IDUtils.ID>999){
            IDUtils.ID=100;
        }
        ran=IDUtils.ID;
        return Long.valueOf(time+info.substring(1, info.length())+ran);
    }
}

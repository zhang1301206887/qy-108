package com.aaa.zk.utils;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/21 18:00
 *@Description:
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public String getNowDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(new Date());
        return nowtime;
    }

}

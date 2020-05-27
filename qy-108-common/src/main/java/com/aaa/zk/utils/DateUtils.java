package com.aaa.zk.utils;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/21 18:00
 *@Description:
 */

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private DateUtils() {

    }
    /**
     * 定义日期格式
     */
    public static final String DATE_TYPE = "yyyy-MM-dd";

    /**
    * @Author: He create on 2020/5/26 17:36
    * @param: []
    * @return: java.lang.String
    * @Description: 获取当时时间并转化为string类型
    */
    public String getNowDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(new Date());
        return nowtime;
    }

    /**
    * @author zk
    * @Date
    *   按照DATE_TYPE格式转换
    */
    public static final String formatDate(Object date){

        if (null == date){
            return null;
        }else{
            return formatDate(date,DATE_TYPE);
        }
    }

    /**
    * @author zk
    * @Date
    *   按照指定的日期格式进行转换
    */
    public static final String formatDate(Object date, String formatType) {

        if (null == date){
            return null;
        }else{
            if (StringUtils.isNotEmpty(formatType)){
                //说明最终需要根据客户所定义的格式来进行转换
                SimpleDateFormat format = new SimpleDateFormat(formatType);
                return format.format(date);
            }else{
                //如果formatType为空说明没有指定时间格式
                return formatDate(date);
            }
        }
    }

    /**
    * @author zk
    * @Date
    *   将时间转换为字符串
    */
    public static String formatDateAgo(long millisecond){
            StringBuilder stringBuilder = new StringBuilder();

            if (1000 > millisecond){
                //说明只是毫秒
                stringBuilder.append(millisecond).append("毫秒");
            }else{
                // 说明传进来的long类型毫秒数大于1000
                Integer ss = 1000;//秒
                Integer mi = ss * 60;//分钟
                Integer hh = mi * 60;//小时
                Integer dd = hh * 24;//天

                Long day = millisecond / dd;
                Long hour = (millisecond - day * dd) / hh;
                Long minute = (millisecond - day * dd - hour * hh) / mi;
                Long second = (millisecond - day * dd - hour * hh - minute * mi) / ss;

                if (day > 365){
                    return formatDate(new Date(millisecond),"yyyy年MM月dd日 HH时mm分ss秒");
                }
                if (day > 0){
                    stringBuilder.append(day).append("天");
                }
                if (hour > 0){
                    stringBuilder.append(hour).append("小时");
                }
                if (minute > 0){
                    stringBuilder.append(minute).append("分钟");
                }
                if (second > 0){
                    stringBuilder.append(second).append("秒");
                }
            }
            return stringBuilder.toString();
    }

    /**
    * @author zk
    * @Date
    *   获取系统当前时间
    */
    public static final String getCurrentDate(){
        return formatDate(new Date());
    }

    /**
    * @author zk
    * @Date
    *   获取当年年度
    */
    public static Integer getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

}

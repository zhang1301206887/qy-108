package com.aaa.zk.utils;

import java.util.Random;


public class FileNameUtils {

    private FileNameUtils() {

    }

   /**
   * @Author: He create on 2020/5/29 20:04
   * @param: []
   * @return: java.lang.String
   * @Description: 生成文件名
   */
    public static String getFileName() {
        // 1.获取系统当前时间的毫秒数
        Long timeMillis = System.currentTimeMillis();
        // 2.创建Random对象
        Random random = new Random();
        // 3.做一个随机数，随机区间是0-999之间随机
        Integer randomNum = random.nextInt(999);
        System.out.println(randomNum);
        // 4.生成最终的文件名(当前系统时间的毫秒数+随机数 来实现)
        /**
         * %:占位符
         * d:数字
         * 03:三位数，如果不够三位自动向前补0
         */
        String fileName = timeMillis + String.format("%03d", randomNum);
        System.out.println(fileName);
        // 5.返回文件名称
        return fileName;
    }

    public static void main(String[] args) {
        FileNameUtils.getFileName();
    }

}

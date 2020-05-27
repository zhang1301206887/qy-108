package com.aaa.zk.utils;

import org.springframework.util.DigestUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.DigestException;
import java.util.Random;

/**
 * @Author zk
 * @Date 2020/5/27
 * 字符串工具类
 */
public class StringUtils {
    private StringUtils(){

    }

    /**
    * @author zk
    * @Date
    *   MD5
    */
    public static String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
    /**
    * @author zk
    * @Date
    *   杀空函数 将"null" 和 null对象转化为""
    */
    public static String KillNull(String str){
        String returnStr;
        if (str == null ||"null".equalsIgnoreCase(str)){
            returnStr = "";
        }else{
            returnStr = str;
        }
        return returnStr;
    }

    /**
    * @author zk
    * @Date
    *   去除字符串两边的空格并且处理字符串
    */
    public static String trim(String str){
        String returnStr;
        returnStr = KillNull(str);
        returnStr = returnStr.trim();
        return  returnStr;
    }
    /**
    * @author zk
    * @Date
    *   判断字符串是否为空
    */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    /**
     * @author zk
     * @Date
     *   判断字符串是否不为空
     */
    public static boolean isNoEmpty(String str) {
        return !isEmpty(str);
    }
    /**
    * @author zk
    * @Date
    *   获取指定长度的随机字母和数字组合
    */
    public static String getCharAndNum(int length) {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                str += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                str += String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }

    /**
    * @author zk
    * @Date
    *   将byte[]数组转为base64文本
    */
    public static final String byteToBase64(byte[] decByte) throws Exception {
        if (decByte == null)
            return "";
        String str = "";
        try {
            str = new sun.misc.BASE64Encoder().encodeBuffer(decByte);
        } catch (Exception e) {
            str = "";
        }
        return str.replace("\r", "").replace("\n", "");
    }

    /**
    * @author zk
    * @Date
    *   将 base64文本 转为  byte[]数组
    */
    public static final byte[] base64ToByte(String str) throws Exception {
        if (str == null)
            return null;
        byte[] decByte = null;
        try {
            decByte = new sun.misc.BASE64Decoder().decodeBuffer(str);
        } catch (Exception e) {
            decByte = null;
        }
        return decByte;
    }

    /**
    * @author zk
    * @Date
    *   将ErrorStack转化为String.
    */
    public static String getExceptionAsString(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

}

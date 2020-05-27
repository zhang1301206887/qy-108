package com.aaa.zk.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zk
 * @Date 2020/5/27
 */
public class IPUtils {
    private IPUtils(){

    }

    private static final String UNKNOWN = "unknown";

    /**
    * @author zk
    * @Date
    *   获取用户的ip地址
    */
    public static String getIpAddr(HttpServletRequest request) {
        // x-forwarded-for就是ip地址
        String ip = request.getHeader("x-forwarded-for");
        // 需要进行严谨判断(如果用户使用的有代理服务器(本地代理服务器，网络代理服务器都需要判断))
        if(ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();// 0:0:0:1.. 127.0.0.1
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

}

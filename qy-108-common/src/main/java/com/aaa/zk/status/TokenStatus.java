package com.aaa.zk.status;/*
 *@Company：
 *@Author：何康
 *@Date：2020/6/2 22:33
 *@Description: zuul中拦截器中用到的String字符
 */

public class TokenStatus {
    public static final String URL_TOKEN = "token";
    public static final String URL_DOLOGIN= "doLogin";
    public static final String URL_LOGIN = "login";
    public static final String URL_HTTP = "http://";
    public static final String URL_HTTPS = "https://";
    //到达路由之前执行
    public static final String TYPE_PRE = "pre";
    //到达路由时执行
    public static final String TYPE_POST = "post";
    //在路由中抛异常的时候(统一的路由异常处理)
    public static final String TYPE_ERROR = "error";
    //在路由之后执行
    public static final String TYPE_ROUTING = "routing";
}

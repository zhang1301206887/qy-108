package com.aaa.zk.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class GetParamsUtils {

    private GetParamsUtils() {

    }
    /**
    * @Author: He create on 2020/6/2 17:29
    * @param: [request]
    * @return: java.lang.String
    * @Description: 获取参数并且转化格式
    */
    public static String getParams(HttpServletRequest request) {
        // GET传参的形式:localhost:8081/login?username=zhangsan&password=123456
        //Stringbuilder效率高 此处应使用Stringbuffer线程安全类型
        StringBuilder params = new StringBuilder("?");
        // 因为是后台程序 所以对安全的考虑没有特别大的要求
        Enumeration<String> names = request.getParameterNames();
        // 判断确定用户使用的就是get请求方式
        if(request.getMethod().toUpperCase().equals("GET")) {
            // 说明使用的就是GET方式
            while(names.hasMoreElements()) {
                String name = names.nextElement();// 其实这里获取的是参数的key值
                params.append(name);
                params.append("=");
                params.append(request.getParameter(name));
                params.append("&");
            }
        }
        if(params.length() > 1) {
            params.delete(params.length() - 1, params.length());
        }
        return params.toString();
    }

}

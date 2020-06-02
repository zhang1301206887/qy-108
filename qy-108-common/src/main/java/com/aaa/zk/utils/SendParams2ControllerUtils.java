package com.aaa.zk.utils;/*
 *@Company：
 *@Author：何康
 *@Date：2020/6/2 18:36
 *@Description:
 */

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.ServletInputStreamWrapper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

public class SendParams2ControllerUtils {
    private SendParams2ControllerUtils(){

    }
    public static void sendPanras(JSONObject bodyJson, RequestContext rcx, HttpServletRequest request){
        String body = bodyJson.toString();
        // 把String转换为字节数组(如果在发送过程中，害怕线程不安全，使用final控制)
        final byte[] bodyBytes = body.getBytes();
        // 一定要把当前的request对象放到当前的上下文对象中
        rcx.setRequest(new HttpServletRequestWrapper(request){
            @Override
            public ServletInputStream getInputStream() throws IOException {
                return new ServletInputStreamWrapper(bodyBytes);
            }

            @Override
            public int getContentLength() {
                return bodyBytes.length;
            }

            @Override
            public long getContentLengthLong() {
                return bodyBytes.length;
            }
        });
    }
}

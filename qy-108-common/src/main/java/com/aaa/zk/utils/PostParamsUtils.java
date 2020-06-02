package com.aaa.zk.utils;/*
 *@Company：
 *@Author：何康
 *@Date：2020/6/2 17:31
 *@Description: 获取POST请求方式的参数
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.context.RequestContext;
import io.micrometer.core.instrument.util.IOUtils;

import javax.servlet.ServletInputStream;
import java.io.IOException;


public class PostParamsUtils {
    private PostParamsUtils(){

    }
    /**
    * @Author: He create on 2020/6/2 18:36
    * @param: [rcx]
    * @return: com.alibaba.fastjson.JSONObject
    * @Description: 获取参数的方法
    */
    public static JSONObject postRarams(RequestContext rcx){
        String body = null;
        if (!rcx.isChunkedRequestBody()){
            ServletInputStream inp;
            try {
                inp = rcx.getRequest().getInputStream();
                if(null != inp) {
                    body = IOUtils.toString(inp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return JSON.parseObject(body);
    }
}

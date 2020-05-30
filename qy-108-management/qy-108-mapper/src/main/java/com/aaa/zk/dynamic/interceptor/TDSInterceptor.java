package com.aaa.zk.dynamic.interceptor;


import com.aaa.zk.dynamic.annotation.TDS;
import com.aaa.zk.dynamic.datasource.DynamicDataSourceContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Author: He create on 2020/5/30 19:18
* @param:
* @return:
* @Description: 设置TDS的拦截器
*/
@Component
public class TDSInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        TDS annotation = handlerMethod.getMethod().getAnnotation(TDS.class);
        if(null == annotation) {
            annotation = handlerMethod.getMethod().getDeclaringClass().getAnnotation(TDS.class);
        }
        if(null != annotation && !"".equals(annotation.value())) {
            DynamicDataSourceContextHolder.setDatasourceType(annotation.value());
        }
        return true;
    }
}

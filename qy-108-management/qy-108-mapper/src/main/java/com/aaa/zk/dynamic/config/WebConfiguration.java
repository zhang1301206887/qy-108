package com.aaa.zk.dynamic.config;


import com.aaa.zk.dynamic.interceptor.TDSInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/30 17:04
 * @Description
 **/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TDSInterceptor());
    }
}

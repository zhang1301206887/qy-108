package com.aaa.zk.config;

import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/29 14:34
 * @Description
 *      这里并不是让feign支持文件上传的配置
 *      而且去修改feign接收请求的请求头信息(把feign接收请求的请求头信息的默认编码集给他改掉)
 *      其实说白了就是来修改整个springcloud架构所接收请求头信息的编码集
 *      这里其实就是把springcloud的请求头编码集修改为既可以接收文件类型，又可以接收普通类型
 **/
@Configuration
public class FeignMultipartConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    @ConditionalOnBean
    public feign.codec.Encoder springFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

}

package com.aaa.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zk
 * @Date 2020/5/21
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationRun6081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6081.class,args);
    }
}

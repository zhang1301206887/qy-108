package com.aaa.zk;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Date Create in 2020/5/12
 * @Description
 *      也可以使用@SpringCloudApplication(新注解)，代替
 *          @SpringBootApplication, @EnableDiscoveryClient, @EnableCircuitBreaker
 **/
@SpringBootApplication
@MapperScan("com.aaa.zk.mapper")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ApplicationRun8081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class, args);
    }

}

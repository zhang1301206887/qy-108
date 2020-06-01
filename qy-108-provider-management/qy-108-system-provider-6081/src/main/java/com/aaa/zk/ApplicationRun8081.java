package com.aaa.zk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * @Author: He create on 2020/5/13 22:47
 * @param:
 * @return:
 * @Description: 使用springbootapplication注解 自动装配时 忽略掉集成的redis配置
 *  使用项目本身的配置
 */
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class,
        DataSourceAutoConfiguration.class
})
@MapperScan("com.aaa.zk.mapper")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ApplicationRun8081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class, args);
    }
}

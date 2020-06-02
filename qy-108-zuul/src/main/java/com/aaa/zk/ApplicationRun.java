package com.aaa.zk;



/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/6/2 15:02
 * @Description
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients(basePackages = {"com.aaa.lee"})
public class ApplicationRun {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }

}

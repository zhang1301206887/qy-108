package com.aaa.zk.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author zk
 * @Date 2020/5/17
 */
@Component
@PropertySource("classpath:properties/ftp.properties")
@ConfigurationProperties(prefix = "spring.ftp")
@Data
public class FTPProperties implements Serializable {

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String basePath;
    private String httpPath;
}

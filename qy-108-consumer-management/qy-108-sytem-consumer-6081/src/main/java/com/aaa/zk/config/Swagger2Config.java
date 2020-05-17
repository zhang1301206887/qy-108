package com.aaa.zk.config;

import jdk.management.resource.ResourceRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.aaa.zk.staticstatus.RequestURLProperties.PACKAGE_CONTROLLER_URL;

/**
 * @Author zk
 * @Date 2020/5/17
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 选择swagger具体生效的接口是什么？(service, controller, mapper)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER_URL))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     *构建了整个项目的一些描述信息
     * */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测绘管理信息")
                .description("某城市的测绘管理系统")
                .contact(new Contact("zk","http://www.zk.com","sfwell@Gmail.com"))
                .version("1.0")
                .build();
    }
}

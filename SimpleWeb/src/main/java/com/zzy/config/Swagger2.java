package com.zzy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年4月26日 
* @decript: 这就是一个初始化swagger的类,但是我他喵的看球不懂
*/
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzy"))   
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 这TM就是设置swagger的默认title
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("本架构由zeus亲自搭建,更多详情www.zeus.com")
                .termsOfServiceUrl("www.zeus.com")
                .contact("Zeus") 
                .version("1.0")
                .build();
    }

}

package com.example;

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
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SweggerConfig {

    /**
     *
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
		        .apiInfo(demoApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build();
    }

    private ApiInfo demoApiInfo() {
        return new ApiInfoBuilder()
            .title("我这不知道这是什么的 API")//大标题
            .description("最好能够成功的展示啊~~")//详细描述
            .termsOfServiceUrl("NO terms of service")
            .contact("孟老师")//作者
            .version("1.0")//版本
            .build();
    }
}

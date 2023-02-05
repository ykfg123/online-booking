package com.doudou.onlinebook.common.configurer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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

/**
 * 在线文档生成,参考网址：https://hacpai.com/article/1534735914420
 * https://blog.csdn.net/sanyaoxu_2/article/details/80555328
 * @author 程就人生
 * @Date
 */
@Configuration
@EnableSwagger2 // 启用 Swagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.doudou.onlinebook.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("这是网站的标题...")
                        .description("这是网站的描述...")
                        .version("v1.0")
                        .contact(new Contact("这是联系人名称", "https://cxy35.com", "123456@qq.com"))
                        .license("这是网站使用的协议...")
                        .licenseUrl("https://www.baidu.com")
                        .build());
    }
}
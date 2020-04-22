package com.memoire.wohaya.config;

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

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new
                ApiInfoBuilder().title("Hohaya REST API")
                .description("REST API for Hohaya project.")
                .contact(new Contact("PADONOU Dieu-Donné", "www.isidorepadonou.com", "abnegalem@gmail.com"))
                .license("Open Source")
                .licenseUrl("https://opensource.org/licenses")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.memoire.wohaya"))
                //.paths(PathSelectors.ant("/wohaya-api/*"))
                .build()
                .apiInfo(apiInfo());
    }

}

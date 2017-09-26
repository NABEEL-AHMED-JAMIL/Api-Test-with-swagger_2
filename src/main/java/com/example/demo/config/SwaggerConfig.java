package com.example.demo.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Nabeel on 9/24/2017.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
            .paths(this.postPaths()).build().apiInfo(metaData());
    }

    private Predicate<String> postPaths() {
        return or(regex("/product.*"), regex("/customer.*"));
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Online Store",
                "1.0",
                "Terms of service",
                new Contact("Nabeel Ahmed", "https://github.com/NABEEL-AHMED-JAMIL", "nabeel.amd93@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}

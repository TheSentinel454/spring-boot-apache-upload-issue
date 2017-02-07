package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Configuration
 *
 * @author ltornquist
 * @since 7/7/2015
 */
@Component
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("demo-api")
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .apiInfo(apiInfo());
    }

    /**
     * Rest API Information
     *
     * @return API Information
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Demo Rest API",
            "Rest API to service the Demo Application",
            "1.0",
            "http://demo.com",
            "Luke Tornquist",
            "License",
            "http://demo.com"
        );
    }
}

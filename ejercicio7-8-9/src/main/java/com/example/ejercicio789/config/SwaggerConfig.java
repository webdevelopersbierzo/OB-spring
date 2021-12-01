package com.example.ejercicio789.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuración Swagger para la generacion de documentacion de la API REST
 *
 * HTML : -> http://localhost:8080/swagger-ui/
 * JSON : -> http://localhost:8080/v2/api-docs
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiDetails(){
        return new ApiInfo("Spring boot Laptop API REST",
                "Library Api Rest Doc",
                "1.0",
                "http://www.google.es",
                new Contact("Oscar","http://www.google.com","oscarcorralg@hotmail.com"),
                "MIT",
                "http://www.google.es",
                Collections.emptyList());

    }
}

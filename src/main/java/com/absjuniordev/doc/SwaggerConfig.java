package com.absjuniordev.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public
class SwaggerConfig {

    @Bean
    public
    OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("Bank International")
                .version("1.0.0")
                .description("Structural base of a Bank")
                .contact(new io.swagger.v3.oas.models.info.Contact()
                        .name("Arnaldo Junior")
                        .url("https://github.com/absjuniordev")
                        .email("abs.junnior@hotmail.com")));
    }
}

package br.com.project.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


//@OpenAPIDefinition(info = @Info(title = "Cliente Service", version = "v1", description = "API de POC para OSB"))
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info().title("Cliente Service").version("v1")
                .license(new License().name("Licenca").url("http://springdoc.org")));
    }

}

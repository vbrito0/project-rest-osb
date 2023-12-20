package br.com.project.rest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@OpenAPIDefinition(info = @Info(title = "Cliente Service", version = "v1", description = "API de POC para OSB"))
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info().title("Cliente Service").version("v1")
                .license(new License().name("Licenca").url("http://springdoc.org")));
    }

}

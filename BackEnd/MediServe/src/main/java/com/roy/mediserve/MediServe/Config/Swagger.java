package com.roy.mediserve.MediServe.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* Use case --> http://localhost:8080/swagger-ui/index.html#/ 
 * configuration class for Swagger API documentation. */

@Configuration
public class Swagger {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MediServe API")
                        .version("1.0.0")
                        .description("API documentation for the MediServe application"));
    }
}

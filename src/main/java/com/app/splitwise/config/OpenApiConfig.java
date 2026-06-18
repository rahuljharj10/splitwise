package com.app.splitwise.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Central OpenAPI/Swagger configuration for documented REST endpoints.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Builds base API metadata rendered in Swagger UI and the OpenAPI document.
     *
     * @return configured OpenAPI model with service metadata
     */
    @Bean
    public OpenAPI splitwiseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Splitwise API")
                        .description("REST API documentation for the Splitwise application")
                        .version("v0.0.1")
                        .contact(new Contact().name("Splitwise Team"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}


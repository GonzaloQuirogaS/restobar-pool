package com.app.restobarpool.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "RestoBar-Pool",
                version = "1.0.0",
                description = "RestoBar-Pool application"
        )
)

public class OpenApiConfig {
}
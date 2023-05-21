package org.hygge.generator.runner.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springdoc.core.utils.Constants.SPRINGDOC_ENABLED;

@ConditionalOnProperty(name = SPRINGDOC_ENABLED, matchIfMissing = true)
@Configuration
public class SwaggerApiConfig {
    @Bean
    public OpenAPI swaggerGeneratorOpenApi() {
        return new OpenAPI()
                .info(new Info().title("Generator API")
                        .description("Generator Everything")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("")));
    }

    @Bean
    public GroupedOpenApi swaggerSecurityApi() {
        return GroupedOpenApi.builder()
                .group("generator-security")
                .packagesToScan("org.hygge.generator.controller.security")
                .build();
    }

    @Bean
    public GroupedOpenApi swaggerTemplateApi() {
        return GroupedOpenApi.builder()
                .group("generator-template")
                .packagesToScan("org.hygge.generator.controller.template")
                .build();
    }
}

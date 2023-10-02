package com.osckorea.openmsa;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiconfig {

    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                                .group("All API")
                                .pathsToMatch("/**")
                                .build();
    }

    @Bean
    public GroupedOpenApi assetApi() {
        return GroupedOpenApi.builder()
                                .group("Nexus Asset API")
                                .pathsToMatch("/v1/assets/**")
                                .build();
    }

    @Bean
    public GroupedOpenApi componentApi() {
        return GroupedOpenApi.builder()
                                .group("Nexus Component API")
                                .pathsToMatch("/v1/components/**")
                                .build();
    }

    @Bean
    public GroupedOpenApi repositoryApi() {
        return GroupedOpenApi.builder()
                                .group("Nexus Repository API")
                                .pathsToMatch("/v1/repository/**")
                                .build();
    }

    @Bean
    public GroupedOpenApi browseApi() {
        return GroupedOpenApi.builder()
                                .group("Nexus Browse Tree Node API")
                                .pathsToMatch("/v1/browse")
                                .build();
    }

    @Bean
    public GroupedOpenApi searchApi() {
        return GroupedOpenApi.builder()
                                .group("Nexus Search API")
                                .pathsToMatch("/v1/search/**")
                                .build();
    }

    @Bean
    public GroupedOpenApi vulnerabilityApi() {
        return GroupedOpenApi.builder()
                                .group("Nexus Vulnerability API")
                                .pathsToMatch("/v1/vulnerability/**")
                                .build();
    }

    @Bean
    public GroupedOpenApi webhookCallBackApi() {
        return GroupedOpenApi.builder()
                                .group("Nexus Webhook API")
                                .pathsToMatch("/v1/webhook/**")
                                // .pathsToExclude("/v1/webhook")
                                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        SecurityScheme basicAuth = new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic");

        SecurityRequirement securityItem = new SecurityRequirement().addList("basicAuth");

        Components components = new Components().addSecuritySchemes("basicAuth", basicAuth);

        Info info = new Info()
                            .version("v1.0.0")
                            .title("Web_admin")
                            .description("SSR UI는 [::]:8080/main 으로 접속하시면 됩니다.");

        return new OpenAPI()
                    .components(components)
                    .addSecurityItem(securityItem)
                    .info(info);
    }
}



package com.osckorea.openmsa.admin;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiconfig {

    @Bean
    public OpenAPI openAPI() {

    Info info = new Info()
            .version("v1.0.0")
            .title("Web_admin")
            .description("서버사이드 렌더링으로 구현 /main/ 주소로 시작하시면 됩니다.");

        return new OpenAPI()
                .info(info);
    }
}


//            Info info = new Info()
//                .version("v1.0.0")
//                .title("Web_admin")
//                .description("API Description");
//
//    /**
//     * 1) API Grouping > ALL
//     */
//    @Bean
//    public GroupedOpenApi allApi() {
//        return GroupedOpenApi.builder()
//                .group("API ALL")
//                .pathsToMatch("/**")
//                .build();
//    }
//    /**
//     * 2) API Grouping > Admin
//     */
//    @Bean
//    public GroupedOpenApi adminApi() {
//        return GroupedOpenApi.builder()
//                .group("ADMIN API")
//                .pathsToMatch("/main/**")
//                //.addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
//                .build();
//    }
//    /**
//     * 3) API Grouping > User
//     */
//    @Bean
//    public GroupedOpenApi loginApi() {
//        return GroupedOpenApi.builder()
//                .group("USER API")
//                .pathsToMatch("/login/**")
//                .build();
//    }
//}


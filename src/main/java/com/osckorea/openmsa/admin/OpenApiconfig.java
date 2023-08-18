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



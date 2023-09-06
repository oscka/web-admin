package com.osckorea.openmsa.admin.nexus.config;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.RequestInterceptor;

@Configuration
public class NexusFeignClientConfiguration {
    @Value("${api.nexus.username}")
    private String username;

    @Value("${api.nexus.password}")
    private String password;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("Authorization", "Basic " + Base64.getEncoder().encodeToString(String.join(":", username, password).getBytes()).toString());
    }
}

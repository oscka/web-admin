package com.osckorea.openmsa.admin.nexus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.auth.BasicAuthRequestInterceptor;

@EnableFeignClients(basePackages = "com.osckorea.openmsa.nexus.*")
@Configuration
public class NexusFeignClientConfiguration {
    @Value("${api.nexus.username}")
    private String username;

    @Value("${api.nexus.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, password);
    }

}

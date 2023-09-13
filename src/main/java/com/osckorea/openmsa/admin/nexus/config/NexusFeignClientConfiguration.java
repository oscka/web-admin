package com.osckorea.openmsa.admin.nexus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

public class NexusFeignClientConfiguration {
    @Value("${api.nexus.username}")
    private String username;

    @Value("${api.nexus.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, password);
    
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

package com.osckorea.openmsa.admin.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.osckorea.openmsa.admin.common.interceptor.LogInCheckInterceptor;

@Configuration
public class AuthInterceptorConfig implements WebMvcConfigurer{
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInCheckInterceptor())
                .order(1)
                .addPathPatterns(
                "/main/boardManagement",
                "/main/viewmanagement")
                .excludePathPatterns("/error");
    }
}

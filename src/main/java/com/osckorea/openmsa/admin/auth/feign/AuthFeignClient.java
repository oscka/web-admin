package com.osckorea.openmsa.admin.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.osckorea.openmsa.admin.auth.domain.UserSession;

@FeignClient(name = "AUTHENTICATION-CLIENT", url = "${api.auth-service.url}")
public interface AuthFeignClient {
    @PostMapping("/security/jwtlogin")
    public UserSession.TokenPayload signIn(UserSession.SignInPayload userInfo);
}
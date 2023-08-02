package com.osckorea.openmsa.admin.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.auth.domain.UserSession;
import com.osckorea.openmsa.admin.auth.feign.AuthFeignClient;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthFeignClient authFeignClient;

    @Value("${jwt.secret}")
    private String secret;

    /**
     * 로그인 요청 및 세션정보 반환 메소드
     * 
     * @param UserSession.SignInPayload userInfo
     * @return UserSession
     */
    public UserSession signIn(UserSession.SignInPayload userInfo) {
        UserSession.TokenPayload tokenData = this.authFeignClient.signIn(userInfo);
        
        if(tokenData == null) {
            return null;
        }

        return UserSession.builder()
                            .user(userInfo)
                            .token(tokenData)
                            .userRole(extractRole(tokenData.getAccessToken()))
                            .build();
    }

    /**
     * JWT Payload 내부 사용자 권한 추출 메소드
     * 
     * @param String token
     * @return String
     */
    private String extractRole(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(secret.getBytes())
                            .parseClaimsJws(token)
                            .getBody();

        return claims.get("role", String.class);
    }
}

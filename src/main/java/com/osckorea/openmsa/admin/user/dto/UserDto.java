package com.osckorea.openmsa.admin.user.dto;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.osckorea.openmsa.admin.user.domain.User;
import com.osckorea.openmsa.admin.user.dto.types.UserInfo;
import com.osckorea.openmsa.global.enums.UserRole;
import com.osckorea.openmsa.global.enums.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {
    @Schema(name = "UserSaveRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Save extends UserInfo{
        @Schema(example = "ray")
        private String id;

        @Schema(type = "enum", example = "ACTIVE")
        private UserStatus status;

        @Schema(example = "010-xxxx-xxxx")
        private String phoneNumber;

        @Schema(type = "enum", example = "ROLE_MEMBER")
        private UserRole role;

        public User toEntity() {
            return User.builder()
                        .userId(this.id)
                        .userPassword(this.password)
                        .userName(this.name)
                        .userStatus(this.status)
                        .userRole(this.role)
                        .userEmail(this.email)
                        .userPhoneNumber(this.phoneNumber)
                        .build();
        }
    }

    @Schema(name = "UserUpdateRequestDto")
    public static class Update extends UserInfo{
        public User toEntity(String id) {
            return User.builder()
                        .userId(id)
                        .userPassword(this.password)
                        .userName(this.name)
                        .userEmail(this.email)
                        .isNew(false)
                        .build();
        }

        public User toEntity(String id, UserStatus status, UserRole role, String phoneNumber) {
            return User.builder()
                        .userId(id)
                        .userPassword(this.password)
                        .userName(this.name)
                        .userStatus(status)
                        .userRole(role)
                        .userEmail(this.email)
                        .userPhoneNumber(phoneNumber)
                        .isNew(false)
                        .build();
        }
    }

    @Schema(name = "UserSignInRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class SignIn {
        @Schema(example = "ray")
        private String id;

        @Schema(example = "password")
        private String password;
    }

    @Schema(name = "UserResponseDto")
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response {
        @Schema(example = "ray")
        private String id;
        @Schema(example = "ray lee")
        private String name;

        @Schema(example = "ACTIVE")
        private UserStatus status;

        @Schema(example = "ROLE_MEMBER")
        private UserRole role;

        @Schema(example = "ray.lee@osckorea.com")
        private String email;

        @Schema(example = "010-xxxx-xxxx")
        private String phoneNumber;

        @Schema(example = "2023-09-22'T'03:05:01")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private Timestamp createdDate;
        
        @Schema(example = "2023-09-22'T'03:05:01")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private Timestamp modifiedDate;
    }
}

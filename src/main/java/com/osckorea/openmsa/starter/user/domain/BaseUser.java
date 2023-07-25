package com.osckorea.openmsa.starter.user.domain;

import lombok.Builder;
import lombok.Value;

import com.osckorea.openmsa.global.enums.UserRole;

import javax.validation.constraints.NotNull;

@Builder
@Value
public class BaseUser {

    @NotNull
    private String loginId;

    @NotNull
    private String password;

    @NotNull
    private UserRole userRole;

}

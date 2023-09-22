package com.osckorea.openmsa.admin.user.dto.types;

import javax.validation.constraints.Pattern;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public abstract class UserInfo {
    @Schema(example = "ray")
    protected String name;

    @Schema(example = "ray.lee@osckorea.com")
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    protected String email;

    @Schema(example = "password")
    protected String password;
}

package com.osckorea.openmsa.admin.repository.npm.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractHostedDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NpmHostedDto {
    @Schema(name = "NpmHostedRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request extends AbstractHostedDto.Request {}

    @Schema(name = "NpmHostedResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response extends AbstractHostedDto.Response {}
}

package com.osckorea.openmsa.nexus.repository.npm.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractProxyDto;
import com.osckorea.openmsa.nexus.repository.npm.dto.types.Npm;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NpmProxyDto {
    @Schema(name = "NpmProxyRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request extends AbstractProxyDto.Request {
        private Npm npm;
    }

    @Schema(name = "NpmProxyResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response extends AbstractProxyDto.Response {
        private Npm npm;
    }
}

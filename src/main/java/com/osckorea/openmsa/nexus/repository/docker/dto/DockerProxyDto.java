package com.osckorea.openmsa.nexus.repository.docker.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractProxyDto;
import com.osckorea.openmsa.nexus.repository.docker.dto.types.Docker;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DockerProxyDto {
    @Schema(name = "DockerProxyRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request extends AbstractProxyDto.Request {
        private Docker docker;
    }

    @Schema(name = "DockerProxyResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response extends AbstractProxyDto.Response {
        private Docker docker;
    }
}

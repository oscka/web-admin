package com.osckorea.openmsa.admin.repository.docker.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractHostedDto;
import com.osckorea.openmsa.admin.repository.docker.dto.types.Docker;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DockerHostedDto {
    @Schema(name = "DockerHostedRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request extends AbstractHostedDto.Request {
        private Docker docker;
    }

    @Schema(name = "DockerHostedResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response extends AbstractHostedDto.Response {
        private Docker docker;
    }
}

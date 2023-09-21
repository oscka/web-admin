package com.osckorea.openmsa.nexus.repository.nuget.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractHostedDto;
import com.osckorea.openmsa.nexus.repository.nuget.dto.types.NugetProxy;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NugetHostedDto {
    @Schema(name = "NugetHostedRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Request extends AbstractHostedDto.Request {
        private NugetProxy nugetProxy;
    }

    @Schema(name = "NugetHostedResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response extends AbstractHostedDto.Response {
        private NugetProxy nugetProxy;
    }
}

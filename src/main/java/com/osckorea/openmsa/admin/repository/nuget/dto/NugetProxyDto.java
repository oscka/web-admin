package com.osckorea.openmsa.admin.repository.nuget.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractProxyDto;
import com.osckorea.openmsa.admin.repository.nuget.dto.types.NugetProxy;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NugetProxyDto {
    @Schema(name = "NugetProxyRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Request extends AbstractProxyDto.Request {
        private NugetProxy nugetProxy;
    }

    @Schema(name = "NugetProxyResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response extends AbstractProxyDto.Response {
        private NugetProxy nugetProxy;
    }
}

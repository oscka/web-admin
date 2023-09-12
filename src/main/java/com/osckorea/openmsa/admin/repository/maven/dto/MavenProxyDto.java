package com.osckorea.openmsa.admin.repository.maven.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractProxyDto;
import com.osckorea.openmsa.admin.repository.maven.dto.types.Maven;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MavenProxyDto {
    @Schema(name = "MavenProxyRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request extends AbstractProxyDto.Request{
        private Maven maven;
    }

    @Schema(name = "MavenProxyResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response extends AbstractProxyDto.Response{
        private Maven maven;
    }
}

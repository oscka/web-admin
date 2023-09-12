package com.osckorea.openmsa.admin.repository.maven.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractHostedDto;
import com.osckorea.openmsa.admin.repository.maven.dto.types.Maven;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MavenHostedDto {
    @Schema(name = "MavenHostedRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request extends AbstractHostedDto.Request{
        private Maven maven;
    }

    @Schema(name = "MavenHostedResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response extends AbstractHostedDto.Response{
        private Maven maven;
    }
}

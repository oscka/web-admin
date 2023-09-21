package com.osckorea.openmsa.nexus.repository.raw.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractHostedDto;
import com.osckorea.openmsa.nexus.repository.raw.dto.types.Raw;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RawHostedDto {
    @Schema(name = "RawHostedRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Request extends AbstractHostedDto.Request {
        private Raw raw;
    }

    @Schema(name = "RawHostedResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response extends AbstractHostedDto.Response {
        private Raw raw;
    }
}

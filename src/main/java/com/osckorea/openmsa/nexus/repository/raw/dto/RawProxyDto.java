package com.osckorea.openmsa.nexus.repository.raw.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractProxyDto;
import com.osckorea.openmsa.nexus.repository.raw.dto.types.Raw;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RawProxyDto {
    @Schema(name = "RawProxyRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Request extends AbstractProxyDto.Request {
        private Raw raw;
    }

    @Schema(name = "RawProxyResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response extends AbstractProxyDto.Response {
        private Raw raw;
    }
}

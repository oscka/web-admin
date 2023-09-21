package com.osckorea.openmsa.nexus.repository.apt.dto;

import com.osckorea.openmsa.nexus.repository.apt.dto.types.Apt;
import com.osckorea.openmsa.nexus.repository.apt.dto.types.AptSigning;
import com.osckorea.openmsa.nexus.repository.common.dto.AbstractProxyDto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AptProxyDto {
    @Schema(name = "AptProxyRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Request extends AbstractProxyDto.Request {
        private Apt apt;
        private AptSigning aptSigning;
    }

    @Schema(name = "AptProxyResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response extends AbstractProxyDto.Response {
        private Apt apt;
        private AptSigning aptSigning;
    }
}

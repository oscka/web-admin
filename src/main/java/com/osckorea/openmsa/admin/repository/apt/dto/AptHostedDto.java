package com.osckorea.openmsa.admin.repository.apt.dto;

import com.osckorea.openmsa.admin.repository.apt.dto.types.Apt;
import com.osckorea.openmsa.admin.repository.apt.dto.types.AptSigning;
import com.osckorea.openmsa.admin.repository.common.dto.AbstractHostedDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AptHostedDto {
    @Schema(name = "AptHostedRequestDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Request extends AbstractHostedDto.Request {
        private Apt apt;
        private AptSigning aptSigning;
    }

    @Schema(name = "AptHostedResponseDto")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response extends AbstractHostedDto.Response {
        private Apt apt;
        private AptSigning aptSigning;
    }
}

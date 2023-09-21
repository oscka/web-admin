package com.osckorea.openmsa.nexus.repository.pypi.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractProxyDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class PypiProxyDto {
    @Schema(name = "PypiProxyRequestDto")
    public static class Request extends AbstractProxyDto.Request {}

    @Schema(name = "PypiProxyResponseDto")
    public static class Response extends AbstractProxyDto.Response {}
}

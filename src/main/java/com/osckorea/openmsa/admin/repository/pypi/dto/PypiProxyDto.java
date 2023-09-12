package com.osckorea.openmsa.admin.repository.pypi.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractProxyDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class PypiProxyDto {
    @Schema(name = "PypiProxyRequestDto")
    public static class Request extends AbstractProxyDto.Request {}

    @Schema(name = "PypiProxyResponseDto")
    public static class Response extends AbstractProxyDto.Response {}
}

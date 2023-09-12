package com.osckorea.openmsa.admin.repository.pypi.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractHostedDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class PypiHostedDto {
    @Schema(name = "PypiHostedRequestDto")
    public static class Request extends AbstractHostedDto.Request {}

    @Schema(name = "PypiHostedResponseDto")
    public static class Response extends AbstractHostedDto.Response {}
}

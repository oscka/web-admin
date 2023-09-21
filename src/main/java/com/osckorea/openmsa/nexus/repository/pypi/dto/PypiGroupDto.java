package com.osckorea.openmsa.nexus.repository.pypi.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class PypiGroupDto {
    @Schema(name = "PypiGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}

    @Schema(name = "PypiGroupResponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

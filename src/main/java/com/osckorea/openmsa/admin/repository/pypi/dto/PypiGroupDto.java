package com.osckorea.openmsa.admin.repository.pypi.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class PypiGroupDto {
    @Schema(name = "PypiGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}

    @Schema(name = "PypiGroupResponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

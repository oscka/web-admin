package com.osckorea.openmsa.nexus.repository.raw.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class RawGroupDto {
    @Schema(name = "RawGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}

    @Schema(name = "RawGroupResponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

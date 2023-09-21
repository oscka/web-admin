package com.osckorea.openmsa.nexus.repository.apt.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class AptGroupDto {
    @Schema(name = "AptGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}

    @Schema(name = "AptGroupResponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

package com.osckorea.openmsa.nexus.repository.npm.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class NpmGroupDto {
    @Schema(name = "NpmGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}

    @Schema(name = "NpmGroupResponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

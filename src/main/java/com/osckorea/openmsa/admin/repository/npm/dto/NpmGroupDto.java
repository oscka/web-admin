package com.osckorea.openmsa.admin.repository.npm.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class NpmGroupDto {
    @Schema(name = "NpmGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}

    @Schema(name = "NpmGroupResponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

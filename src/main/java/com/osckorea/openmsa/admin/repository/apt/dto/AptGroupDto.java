package com.osckorea.openmsa.admin.repository.apt.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class AptGroupDto {
    @Schema(name = "AptGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}

    @Schema(name = "AptGroupResponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

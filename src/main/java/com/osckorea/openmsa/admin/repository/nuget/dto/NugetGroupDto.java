package com.osckorea.openmsa.admin.repository.nuget.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class NugetGroupDto {
    @Schema(name = "NugetGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}
    
    @Schema(name = "NugetGroupResponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

package com.osckorea.openmsa.nexus.repository.docker.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class DockerGroupDto {
    @Schema(name = "DockerGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}

    @Schema(name = "DockerGroupResponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

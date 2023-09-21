package com.osckorea.openmsa.nexus.repository.maven.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class MavenGroupDto {
    @Schema(name = "MavenGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}
    
    @Schema(name = "MavenGroupReponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

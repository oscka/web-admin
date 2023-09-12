package com.osckorea.openmsa.admin.repository.maven.dto;

import com.osckorea.openmsa.admin.repository.common.dto.AbstractGroupDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class MavenGroupDto {
    @Schema(name = "MavenGroupRequestDto")
    public static class Request extends AbstractGroupDto.Request {}
    
    @Schema(name = "MavenGroupReponseDto")
    public static class Response extends AbstractGroupDto.Response {}
}

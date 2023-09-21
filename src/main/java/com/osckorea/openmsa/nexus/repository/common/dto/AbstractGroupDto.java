package com.osckorea.openmsa.nexus.repository.common.dto;

import com.osckorea.openmsa.nexus.repository.common.dto.types.Group;
import com.osckorea.openmsa.nexus.repository.common.dto.types.Storage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class AbstractGroupDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public abstract static class Request {
        private String name;
        private String online;
        private Storage storage;
        private Group group;
    }

    @Schema(description = "그룹 저장소 DTO")
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public abstract static class Response {
        private String name;
        private String format;
        private String type;
        private String url;
        private Boolean online;
        private Storage storage;
        private Group group;
    }
}

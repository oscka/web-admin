package com.osckorea.openmsa.admin.nexus.dto.repository.maven;

import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Cleanup;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Component;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Storage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MavenHostedDto {
    @Getter
    @Builder
    public static class Request {
        private String name;

        @Builder.Default
        private Boolean online = true;

        private Storage storage;
        private Cleanup cleanup;
        private Component component;
        private Maven maven;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response {
        private String name;
        private String url;
        private Boolean online;
        private Storage storage;
        private Cleanup cleanup;
        private Maven maven;
        private Component component;
        private String format;
        private String type;
    }
}

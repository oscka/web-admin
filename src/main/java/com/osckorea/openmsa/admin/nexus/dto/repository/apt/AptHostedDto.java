package com.osckorea.openmsa.admin.nexus.dto.repository.apt;

import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Cleanup;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Component;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Storage;

import lombok.Builder;
import lombok.Getter;

public class AptHostedDto {
    @Getter
    @Builder
    public static class Request {
        private String name;

        @Builder.Default
        private Boolean online = true;

        private Storage storage;
        private Cleanup cleanup;
        private Component component;
        private Apt apt;
        private AptSigning aptSigning;
    }
    
    @Getter
    public static class Response {
        private String name;
        private String url;
        private Boolean online;
        private Storage storage;
        private Cleanup cleanup;
        private Apt apt;
        private AptSigning aptSigning;
        private Component component;
        private String format;
        private String type;
    }
}

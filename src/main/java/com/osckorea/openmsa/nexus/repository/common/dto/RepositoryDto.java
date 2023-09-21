package com.osckorea.openmsa.nexus.repository.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RepositoryDto {
    @Getter
    @Builder
    public static class Request {
        @Builder.Default
        private Integer page = 1;

        @Builder.Default
        private Integer limit = 30;

        @Builder.Default
        private Integer start = 0;

        @Builder.Default
        private Filter[] filter = null;

        @Getter
        @Builder
        public static class Filter {
            private String property;
            private String value;
        }
    }
    
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response {
        private String id;
        private String name;
        private String type;
        private String format;
        private String versionPolicy;
        private String url;
        private Status status;
        private Integer sortOrder;
        
        @Getter
        @NoArgsConstructor
        // @AllArgsConstructor
        public static class Status {
            private String repositoryName;
            private Boolean online;
            private String description;
            private String reason;
        }
    }
}

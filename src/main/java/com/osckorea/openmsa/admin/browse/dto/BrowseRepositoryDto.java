package com.osckorea.openmsa.admin.browse.dto;

import lombok.Builder;
import lombok.Getter;

public class BrowseRepositoryDto {
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
        private Filter[] filter = new Filter[0];
        
        @Getter
        @Builder
        public static class Filter {
            private String property;
            private String value;
        }
    }

    @Getter
    public class Response {
        private String id;
        private String name;
        private String type;
        private String format;
        private String versionPolicy;
        private String url;
        private Status status;
        private Integer sortOrder;
        
        @Getter
        public static class Status {
            private String repositoryName;
            private Boolean online;
            private String descroption;
            private String reason;
        }
    }
}

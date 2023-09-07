package com.osckorea.openmsa.admin.browse.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BrowseTreeDto {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Request {
        private String repositoryName;
        private String node;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Response {
        private String id;
        private String text;
        private String type;
        private Boolean leaf;
        private String componentId;
        private String assetId;
        private String packageUrl;
    }
}

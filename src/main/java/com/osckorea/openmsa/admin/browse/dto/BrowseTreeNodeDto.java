package com.osckorea.openmsa.admin.browse.dto;

import lombok.Builder;
import lombok.Getter;

public class BrowseTreeNodeDto {
    @Getter
    @Builder
    public static class Request {
        private String repositoryName;
        private String node;
    }

    @Getter
    public static class Response {
        private String id;
        private String text;
        private String type;
        private String leaf;
        private String componentId;
        private String assetId;
        private String pacakageUrl;
    }
}

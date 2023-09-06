package com.osckorea.openmsa.admin.browse.dto;

import lombok.Getter;

public class BrowseTreeDto {
    @Getter
    public class Request {
        private String repositoryName;
        private String node;
    }

    @Getter
    public class Response {
        private String id;
        private String text;
        private String type;
        private Boolean leaf;
        private String componentId;
        private String assetId;
        private String packageUrl;
    }
}

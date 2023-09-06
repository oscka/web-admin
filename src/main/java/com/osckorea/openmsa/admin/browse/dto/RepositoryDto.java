package com.osckorea.openmsa.admin.browse.dto;

import lombok.Getter;

public class RepositoryDto {
    
    @Getter
    public static class Response {
        private String id;
        private String name;
    }

    @Getter
    public static class ResponseDetail {
        private String name;
        private String type;
        private String format;
        private String url;
        private Status status;
    }
    
    @Getter
    public static class Status {
        private Boolean online;
        private String description;
        private String reason;
    }
}

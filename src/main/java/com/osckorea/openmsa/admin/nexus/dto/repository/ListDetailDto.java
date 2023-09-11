package com.osckorea.openmsa.admin.nexus.dto.repository;

import lombok.Getter;

@Getter
public class ListDetailDto {
    private String name;
    private String type;
    private String format;
    private String url;
    private Status status;

    @Getter
    public static class Status {
        private Boolean online;
        private String description;
        private String reason;
    }
}

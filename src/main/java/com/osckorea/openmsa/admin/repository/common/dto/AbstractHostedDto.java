package com.osckorea.openmsa.admin.repository.common.dto;

import com.osckorea.openmsa.admin.repository.common.dto.types.Cleanup;
import com.osckorea.openmsa.admin.repository.common.dto.types.Component;
import com.osckorea.openmsa.admin.repository.common.dto.types.Storage;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class AbstractHostedDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public abstract static class Request {
        private String name;
        private Boolean online;
        private Storage storage;
        private Cleanup cleanup;
        private Component component;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public abstract static class Response {
        private String name;
        private String url;
        private Boolean online;
        private Storage storage;
        private Cleanup cleanup;
        private Component component;
        private String format;
        private String type;
    }
}

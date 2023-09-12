package com.osckorea.openmsa.admin.repository.common.dto;

import com.osckorea.openmsa.admin.repository.common.dto.types.Cleanup;
import com.osckorea.openmsa.admin.repository.common.dto.types.HttpClient;
import com.osckorea.openmsa.admin.repository.common.dto.types.NegativeCache;
import com.osckorea.openmsa.admin.repository.common.dto.types.Replication;
import com.osckorea.openmsa.admin.repository.common.dto.types.Storage;
import com.osckorea.openmsa.admin.repository.common.dto.types.Attributes.Proxy;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class AbstractProxyDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public abstract static class Request {
        private String name;
        private Boolean online;
        private Storage storage;
        private Cleanup cleanup;
        private Proxy proxy;
        private NegativeCache negativeCache;
        private HttpClient httpClient;
        private String routingRule;
        private Replication replication;
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
        private Proxy proxy;
        private NegativeCache negativeCache;
        private HttpClient httpClient;
        private String routingRule;
        private String format;
        private String type;
    }
}

package com.osckorea.openmsa.admin.nexus.dto.repository.maven;

import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Cleanup;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.HttpClient;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.NegativeCache;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Proxy;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Replication;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Storage;
import lombok.Builder;
import lombok.Getter;

public class MavenProxyDto {
    @Getter
    @Builder
    public static class Request {
        private String name;
        private Boolean online;
        private Storage storage;
        private Cleanup cleanup;
        private Proxy proxy;
        private NegativeCache negativeCache;
        private HttpClient httpClient;
        private String routingRule;
        private Replication replication;
        private Maven maven;
    }

    @Getter
    public static class Response {
        private String name;
        private String url;
        private Boolean online;
        private Storage storage;
        private Cleanup cleanup;
        private Proxy proxy;
        private NegativeCache negativeCache;
        private HttpClient httpClient;
        private String routingRule;
        private Maven maven;
        private String format;
        private String type;
    }
}
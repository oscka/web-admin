package com.osckorea.openmsa.admin.nexus.dto.docker;

import com.osckorea.openmsa.admin.nexus.dto.partial.Cleanup;
import com.osckorea.openmsa.admin.nexus.dto.partial.HttpClient;
import com.osckorea.openmsa.admin.nexus.dto.partial.NegativeCache;
import com.osckorea.openmsa.admin.nexus.dto.partial.Proxy;
import com.osckorea.openmsa.admin.nexus.dto.partial.Storage;
import lombok.Getter;

@Getter
public class DockerProxyDto {
    private String name;
    private String url;
    private String format;
    private String type;
    private Boolean online;

    private Storage storage;
    private Cleanup cleanup;
    private Proxy proxy;
    private NegativeCache negativeCache;
    private HttpClient httpClient;
    private String routingRuleName;

    private Docker docker;
}

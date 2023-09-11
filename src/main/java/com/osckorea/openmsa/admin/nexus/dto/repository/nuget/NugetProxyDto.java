package com.osckorea.openmsa.admin.nexus.dto.repository.nuget;

import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Cleanup;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.HttpClient;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.NegativeCache;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Proxy;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Storage;

import lombok.Getter;

@Getter
public class NugetProxyDto {
    private String name;
    private String url;
    private String format;
    private String type;

    private Storage storage;
    private Cleanup cleanup;
    private Proxy proxy;
    private NegativeCache negativeCache;
    private HttpClient httpClient;
    private String routingRuleName;
    
    private NugetProxy nugetProxy;
}

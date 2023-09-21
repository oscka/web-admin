package com.osckorea.openmsa.nexus.repository.docker.dto.types;

import lombok.Getter;

@Getter
public class Docker {
    private Boolean v1Enabled;
    private Boolean forceBasicAuth;
    private Integer httpPort;
    private Integer httpsPort;
    private String subdomain;
}

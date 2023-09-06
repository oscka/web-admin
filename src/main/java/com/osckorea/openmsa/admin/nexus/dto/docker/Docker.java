package com.osckorea.openmsa.admin.nexus.dto.docker;

import lombok.Getter;

@Getter
public class Docker {
    private Boolean v1Enabled;
    private Boolean forceBasicAuth;
    private Integer httpPort;
    private Integer httpsPort;
    private String subdomain;
}

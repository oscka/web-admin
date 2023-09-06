package com.osckorea.openmsa.admin.nexus.dto.partial;

import lombok.Getter;

@Getter
public class Proxy {
    private String remoteUrl;
    private Integer contentMaxAge;
    private Integer metadataMaxAge;
}

package com.osckorea.openmsa.admin.nexus.dto.partial;

import lombok.Getter;

@Getter
public class Attributes {
    private Proxy proxy;

    @Getter
    public static class Proxy {
        private String remoteUrl;
    }
}

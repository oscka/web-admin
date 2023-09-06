package com.osckorea.openmsa.admin.nexus.dto.partial;

import lombok.Getter;

@Getter
public class HttpClient {
    private Boolean blocked;
    private Boolean autoBlock;
    private Connection connection;
    private Authentication authentication;

    @Getter
    public static class Connection {
        private Integer retries;
        private String userAgentSuffix;
        private Integer timeout;
        private Boolean enableCircularRedirects;
        private Boolean enableCookies;
        private Boolean useTrustStore;
    }

    @Getter
    public static class Authentication {
        private String type;
        private String username;
        private String ntlmHost;
        private String ntlmDomain;
    }
}

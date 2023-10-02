package com.osckorea.openmsa.nexus.webhook.audit.dto.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Audit {
    @Schema(example = "security.user")
    private String domain;

    @Schema(example = "created")
    private String type;

    @Schema(example = "TestUser")
    private String context;
    
    private AuditAttributes attributes;
}

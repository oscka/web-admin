package com.osckorea.openmsa.nexus.webhook.repository.dto.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(name = "WebhookRepositoryType")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Repository {
    @Schema(example = "maven-proxy")
    private String format;
    @Schema(example = "maven-central")
    private String name;
    @Schema(example = "proxy")
    private String type;
}

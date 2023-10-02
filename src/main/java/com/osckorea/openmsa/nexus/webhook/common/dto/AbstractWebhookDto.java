package com.osckorea.openmsa.nexus.webhook.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public abstract class AbstractWebhookDto {
    @Schema(example = "7FFA7361-6ED33978-36997BD4-47095CC4-331356BE")
    private String nodeId;

    @Schema(example = "admin/127.0.0.1")
    private String initiator;
}

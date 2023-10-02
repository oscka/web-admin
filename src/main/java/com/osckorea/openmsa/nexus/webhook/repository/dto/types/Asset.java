package com.osckorea.openmsa.nexus.webhook.repository.dto.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(name = "WebhookAssetType")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Asset {
    @Schema(example = "31c950c8eeeab78336308177ae9c441c")
    private String id;

    @Schema(example = "bnBtLXByb3h5OjMxYzk1MGM4ZWVlYWI3ODMzNjMwODE3N2FlOWM0NDFj")
    private String assetId;

    @Schema(example = "maven2")
    private String format;

    @Schema(example = "log4j-core.jar")
    private String name;
}

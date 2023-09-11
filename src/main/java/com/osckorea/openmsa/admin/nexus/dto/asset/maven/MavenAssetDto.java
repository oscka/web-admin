package com.osckorea.openmsa.admin.nexus.dto.asset.maven;

import lombok.Getter;

@Getter
public class MavenAssetDto {
    private MavenItem[] items;
    private String continuationToken;
}

package com.osckorea.openmsa.nexus.asset.maven.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MavenAssetPagingDto {
    private MavenAssetDto[] items;
    private String continuationToken;
}

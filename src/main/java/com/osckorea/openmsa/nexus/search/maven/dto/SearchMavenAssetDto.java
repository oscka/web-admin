package com.osckorea.openmsa.nexus.search.maven.dto;

import lombok.Getter;

@Getter
public class SearchMavenAssetDto {
    private MavenAssetDto[] items;
    private String continuationToken;
}

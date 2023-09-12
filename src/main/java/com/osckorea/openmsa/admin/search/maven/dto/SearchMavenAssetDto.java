package com.osckorea.openmsa.admin.search.maven.dto;

import lombok.Getter;

@Getter
public class SearchMavenAssetDto {
    private MavenAssetDto[] items;
    private String continuationToken;
}

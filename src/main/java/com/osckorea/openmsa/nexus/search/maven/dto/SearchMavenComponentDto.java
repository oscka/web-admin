package com.osckorea.openmsa.nexus.search.maven.dto;

import lombok.Getter;

@Getter
public class SearchMavenComponentDto {
    private MavenComponentDto[] items;
    private String continuationToken;
}

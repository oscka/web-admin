package com.osckorea.openmsa.admin.search.maven.dto;

import lombok.Getter;

@Getter
public class SearchMavenComponentDto {
    private MavenComponentDto[] items;
    private String continuationToken;
}

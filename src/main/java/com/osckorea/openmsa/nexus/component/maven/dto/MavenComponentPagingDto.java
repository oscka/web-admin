package com.osckorea.openmsa.nexus.component.maven.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MavenComponentPagingDto {
    private MavenComponentDto[] items;
    private String continuationToken;
}

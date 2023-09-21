package com.osckorea.openmsa.nexus.repository.nuget.dto.types;

import lombok.Getter;

@Getter
public class NugetProxy {
    private Integer queryCacheItemMaxAge;
    private String nugetVersion;
}

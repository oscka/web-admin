package com.osckorea.openmsa.admin.repository.nuget.dto.types;

import lombok.Getter;

@Getter
public class NugetProxy {
    private Integer queryCacheItemMaxAge;
    private String nugetVersion;
}

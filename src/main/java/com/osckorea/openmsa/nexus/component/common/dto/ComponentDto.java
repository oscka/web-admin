package com.osckorea.openmsa.nexus.component.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ComponentDto {
    private String id;
    private String repository;
    private String format;
    private String group;
    private String name;
    private String version;
}
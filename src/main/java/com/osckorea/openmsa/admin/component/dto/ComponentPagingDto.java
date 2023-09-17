package com.osckorea.openmsa.admin.component.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ComponentPagingDto {
    private ComponentApiDto[] items;
    private String continuationToken;
}

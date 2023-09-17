package com.osckorea.openmsa.admin.component.dto;

import com.osckorea.openmsa.admin.component.domain.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ComponentRepositoryDto {
    private String id;
    private String repository;
    private String format;
    private String group;
    private String name;
    private String version;
    private Integer criticalCount;
    private Integer severeCount;
    private Integer moderateCount;

    public Component toEntity () {
        return Component.builder()
                        .componentId(this.id)
                        .repositoryId(this.repository)
                        .groupId(this.group)
                        .format(this.format)
                        .name(this.name)
                        .version(this.version)
                        .criticalCount(this.criticalCount)
                        .severeCount(this.severeCount)
                        .moderateCount(this.moderateCount)
                        .build();
    }
}

package com.osckorea.openmsa.admin.component.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Persistable;
import com.osckorea.openmsa.admin.component.dto.ComponentRepositoryDto;
import io.micrometer.core.lang.Nullable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table("maven2_component")
public class Component implements Persistable<String>{
    @Id
    @Setter
    @Column("component_id")
    private String componentId;

    @Column("repository_id")
    private String repositoryId;
    
    @Column("group_id")
    private String groupId;

    @Column("format")
    private String format;

    @Column("name")
    private String name;
    
    @Column("version")
    private String version;
    
    @Column("package_url")
    private String packageUrl;

    @Builder.Default
    @Column("vulnerability_critical_count")
    private Integer criticalCount = 0;
    
    @Builder.Default
    @Column("vulnerability_severe_count")
    private Integer severeCount = 0;

    @Builder.Default
    @Column("vulnerability_moderate_count")
    private Integer moderateCount = 0;

    @Setter
    @Transient
    @JsonIgnore
    @Builder.Default
    private boolean isNew = true;

    @Override
    @Nullable
    @JsonIgnore
    public String getId() {
        return this.componentId;
    }

    public ComponentRepositoryDto toDto() {
        return ComponentRepositoryDto.builder()
                                        .id(this.componentId)
                                        .repository(this.repositoryId)
                                        .group(this.groupId)
                                        .format(this.format)
                                        .name(this.name)
                                        .version(this.version)
                                        .criticalCount(this.criticalCount)
                                        .severeCount(this.severeCount)
                                        .moderateCount(this.moderateCount)
                                        .build();
    }


}

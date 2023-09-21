package com.osckorea.openmsa.nexus.component.maven.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
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
public class MavenComponent implements Persistable<String> {
    @Id
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

    @Setter
    @Transient
    @Builder.Default
    private boolean isNew = true;

    public String getId() {
        return this.componentId;
    }
}

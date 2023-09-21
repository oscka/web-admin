package com.osckorea.openmsa.nexus.component.maven.dto.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Maven2 {
    private String extension;
    private String groupId;
    private String artifactId;
    private String version;
}

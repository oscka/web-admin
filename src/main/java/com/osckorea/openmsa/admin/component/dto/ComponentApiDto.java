package com.osckorea.openmsa.admin.component.dto;

import com.osckorea.openmsa.admin.component.domain.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComponentApiDto {
    private String id;
    private String repository;
    private String format;
    private String group;
    private String name;
    private String version;
    private Object[] assets;

    public Component toEntity() {
        return Component.builder()
                        .componentId(this.id)
                        .repositoryId(this.repository)
                        .groupId(this.group)
                        .packageUrl(convertPackageUrl(this.group, this.name, this.version))
                        .format(this.format)
                        .name(this.name)
                        .version(this.version)
                        .build();
    }

    private String convertPackageUrl(String componentGroup, String componentName, String componentVersion) {
        StringBuilder packageUrl = new StringBuilder("pkg:maven/");

        packageUrl.append(componentGroup);
        packageUrl.append("/");
        packageUrl.append(componentName);
        packageUrl.append("@");
        packageUrl.append(componentVersion);

        return packageUrl.toString();
    }
}

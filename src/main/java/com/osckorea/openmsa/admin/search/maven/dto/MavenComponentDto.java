package com.osckorea.openmsa.admin.search.maven.dto;

import com.osckorea.openmsa.admin.search.common.dto.ComponentDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MavenComponentDto extends ComponentDto {
    private MavenAssetDto[] assets;
}

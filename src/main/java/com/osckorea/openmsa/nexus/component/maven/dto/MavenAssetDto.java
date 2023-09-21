package com.osckorea.openmsa.nexus.component.maven.dto;

import com.osckorea.openmsa.nexus.component.common.dto.AssetDto;
import com.osckorea.openmsa.nexus.component.maven.dto.types.Maven2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MavenAssetDto extends AssetDto{
    private Maven2 maven2;
}

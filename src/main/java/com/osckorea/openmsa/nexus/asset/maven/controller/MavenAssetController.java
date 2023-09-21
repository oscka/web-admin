package com.osckorea.openmsa.nexus.asset.maven.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.nexus.asset.maven.dto.MavenAssetDto;
import com.osckorea.openmsa.nexus.asset.maven.service.MavenAssetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Maven 저장소 Asset API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class MavenAssetController {
    private final MavenAssetService mavenAssetService;

    @Operation(summary = "Maven 저장소에 있는 모든 Asset의 목록을 가져옵니다.")
    @GetMapping("assets/{repositoryName}")
    public List<MavenAssetDto> getMavenAssetList(@PathVariable("repositoryName") String repositoryName) {
        return this.mavenAssetService.getMavenAssetList(repositoryName);
    }

    @Operation(summary = "Maven 저장소에 있는 총 Asset의 수를 계산합니다.")
    @GetMapping("assets/count/{repositoryName}")
    public Integer getNumberOfMavenAsset(@PathVariable("repositoryName") String repositoryName) {
        return this.mavenAssetService.getNumberOfMavenAsset(repositoryName);
    }
}

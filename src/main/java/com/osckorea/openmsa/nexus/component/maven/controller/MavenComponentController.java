package com.osckorea.openmsa.nexus.component.maven.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.nexus.component.maven.dto.MavenComponentDto;
import com.osckorea.openmsa.nexus.component.maven.service.MavenComponentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Maven 저장소 Component API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class MavenComponentController {
    private final MavenComponentService mavenComponentService;

    @Operation(summary = "Maven 저장소에 있는 모든 Component의 목록을 호출합니다.")
    @GetMapping("components/{repositoryName}")
    public List<MavenComponentDto> getMavenComponentList(@PathVariable("repositoryName") String repositoryName) {
        return this.mavenComponentService.getMavenComponentList(repositoryName);
    }

    @Operation(summary = "Maven 저장소에 있는 모든 Component의 수를 계산합니다.")
    @GetMapping("components/count/{repositoryName}")
    public Integer getNumberOfMavenComponent(@PathVariable("repositoryName") String repositoryName) {
        return this.mavenComponentService.getNumberOfMavenComponent(repositoryName);
    }
}

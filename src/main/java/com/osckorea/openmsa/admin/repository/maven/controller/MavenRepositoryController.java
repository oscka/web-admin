package com.osckorea.openmsa.admin.repository.maven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.admin.repository.maven.dto.MavenGroupDto;
import com.osckorea.openmsa.admin.repository.maven.dto.MavenHostedDto;
import com.osckorea.openmsa.admin.repository.maven.dto.MavenProxyDto;
import com.osckorea.openmsa.admin.repository.maven.service.MavenRepositoryService;

import lombok.RequiredArgsConstructor;

@Tag(name = "Maven 저장소 API", description = "Nexus Maven 저장소 RESTful CRU 관련 API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class MavenRepositoryController {
    private final MavenRepositoryService mavenRepositoryService;
    
    @Operation(summary = "Maven Group 저장소 조회")
    @GetMapping("repository/maven2/group/{repositoryName}")
    public MavenGroupDto.Response getMavenGroupRepository(@PathVariable("repositoryName") String name) {
        return this.mavenRepositoryService.getMavenGroupRepository(name);
    }

    @Operation(summary = "Maven Hosted 저장소 조회")
    @GetMapping("repository/maven2/hosted/{repositoryName}")
    public MavenHostedDto.Response getMavenHostedRepository(@PathVariable("repositoryName") String name) {
        return this.mavenRepositoryService.getMavenHostedRepository(name);
    }

    @Operation(summary = "Maven Proxy 저장소 조회")
    @GetMapping("repository/maven2/proxy/{repositoryName}")
    public MavenProxyDto.Response getMavenProxyRepository(@PathVariable("repositoryName") String name) {
        return this.mavenRepositoryService.getMavenProxyRepository(name);
    }

    @Operation(summary = "Maven Group 저장소 생성")
    @PostMapping("repository/maven2/group")
    public Integer createMavenGroupRepository(@RequestBody MavenGroupDto.Request data) {
        return this.mavenRepositoryService.createMavenGroupRepository(data);
    }

    @Operation(summary = "Maven Hosted 저장소 생성")
    @PostMapping("repository/maven2/hosted")
    public Integer createMavenHostedRepository(@RequestBody MavenHostedDto.Request data) {
        return this.mavenRepositoryService.createMavenHostedRepository(data);
    }

    @Operation(summary = "Maven Proxy 저장소 생성")
    @PostMapping("repository/maven2/proxy")
    public Integer createMavenProxyRepository(@RequestBody MavenProxyDto.Request data) {
        return this.mavenRepositoryService.createMavenProxyRepository(data);
    }

    @Operation(summary = "Maven Group 저장소 갱신")
    @PutMapping("repository/maven2/group/{repositoryName}")
    public Integer updateMavenGroupRepository(@PathVariable("repositoryName") String name, @RequestBody MavenGroupDto.Request data) {
        return this.mavenRepositoryService.updateMavenGroupRepository(name, data);
    }

    @Operation(summary = "Maven Hosted 저장소 갱싱")
    @PutMapping("repository/maven2/hosted/{repositoryName}")
    public Integer updateMavenHostedRepository(@PathVariable("repositoryName") String name, @RequestBody MavenHostedDto.Request data) {
        return this.mavenRepositoryService.updateMavenHostedRepository(name, data);
    }

    @Operation(summary = "Maven Proxy 저장소 갱신")
    @PutMapping("repository/maven2/proxy/{repositoryName}")
    public Integer updateMavenProxyRepository(@PathVariable("repositoryName") String name, @RequestBody MavenProxyDto.Request data) {
        return this.mavenRepositoryService.updateMavenProxyRepository(name, data);
    }
}

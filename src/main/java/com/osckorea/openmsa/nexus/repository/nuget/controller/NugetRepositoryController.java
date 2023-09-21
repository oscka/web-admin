package com.osckorea.openmsa.nexus.repository.nuget.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.nexus.repository.nuget.dto.NugetGroupDto;
import com.osckorea.openmsa.nexus.repository.nuget.dto.NugetHostedDto;
import com.osckorea.openmsa.nexus.repository.nuget.dto.NugetProxyDto;
import com.osckorea.openmsa.nexus.repository.nuget.service.NugetRepositoryService;
import lombok.RequiredArgsConstructor;

@Tag(name = "Nuget 저장소 API", description = "Nexus Nuget 저장소 RESTful CRU 관련 API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class NugetRepositoryController {
    private final NugetRepositoryService nugetRepositoryService;

    @Operation(summary = "Nuget Group 저장소 조회")
    @GetMapping("repository/nuget/group/{repositoryName}")
    public NugetGroupDto.Response getNugetGroupRepository(@PathVariable("repositoryName") String name) {
        return this.nugetRepositoryService.getNugetGroupRepository(name);
    }

    @Operation(summary = "Nuget Hosted 저장소 조회")
    @GetMapping("repository/nuget/hosted/{repositoryName}")
    public NugetHostedDto.Response getNugetHostedRepository(@PathVariable("repositoryName") String name) {
        return this.nugetRepositoryService.getNugetHostedRepository(name);
    }

    @Operation(summary = "Nuget Proxy 저장소 조회")
    @GetMapping("repository/nuget/proxy/{repositoryName}")
    public NugetProxyDto.Response getNugetProxyRepository(@PathVariable("repositoryName") String name) {
        return this.nugetRepositoryService.getNugetProxyRepository(name);
    }

    @Operation(summary = "Nuget Group 저장소 생성")
    @PostMapping("repository/nuget/group")
    public Integer createNugetGroupRepository(@RequestBody NugetGroupDto.Request data) {
        return this.nugetRepositoryService.createNugetGroupRepository(data);
    }

    @Operation(summary = "Nuget Hosted 저장소 생성")
    @PostMapping("repository/nuget/hosted")
    public Integer createNugetHostedRepository(@RequestBody NugetHostedDto.Request data) {
        return this.nugetRepositoryService.createNugetHostedRepository(data);
    }

    @Operation(summary = "Nuget Proxy 저장소 생성")
    @PostMapping("repository/nuget/proxy")
    public Integer createNugetProxyRepository(@RequestBody NugetProxyDto.Request data) {
        return this.nugetRepositoryService.createNugetProxyRepository(data);
    }

    @Operation(summary = "Nuget Group 저장소 갱신")
    @PutMapping("repository/nuget/group/{repositoryName}")
    public Integer updateNugetGroupRepository(@PathVariable("repositoryName") String name, @RequestBody NugetGroupDto.Request data) {
        return this.nugetRepositoryService.updateNugetGroupRepository(name, data);
    }

    @Operation(summary = "Nuget Hosted 저장소 갱신")
    @PutMapping("repository/nuget/hosted/{repositoryName}")
    public Integer updateNugetHostedRepository(@PathVariable("repositoryName") String name, @RequestBody NugetHostedDto.Request data) {
        return this.nugetRepositoryService.updateNugetHostedRepository(name, data);
    }

    @Operation(summary = "Nuget Proxy 저장소 갱신")
    @PutMapping("repository/nuget/proxy/{repositoryName}")
    public Integer updateNugetProxyRepository(@PathVariable("repositoryName") String name, @RequestBody NugetProxyDto.Request data) {
        return this.nugetRepositoryService.updateNugetProxyRepository(name, data);
    }
}

package com.osckorea.openmsa.nexus.repository.npm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.nexus.repository.npm.dto.NpmGroupDto;
import com.osckorea.openmsa.nexus.repository.npm.dto.NpmHostedDto;
import com.osckorea.openmsa.nexus.repository.npm.dto.NpmProxyDto;
import com.osckorea.openmsa.nexus.repository.npm.service.NpmRepositoryService;

import lombok.RequiredArgsConstructor;

@Tag(name = "NPM 저장소 API", description = "Nexus NPM 저장소 RESTful CRU 관련 API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class NpmRepositoryController {
    private final NpmRepositoryService npmRepositoryService;

    @Operation(summary = "NPM Group 저장소 조회")
    @GetMapping("repository/npm/group/{repositoryName}")
    public NpmGroupDto.Response getNpmGroupRepository(@PathVariable("repositoryName") String name) {
        return this.npmRepositoryService.getNpmGroupRepository(name);
    }

    @Operation(summary = "NPM Hosted 저장소 조회")
    @GetMapping("repository/npm/hosted/{repositoryName}")
    public NpmHostedDto.Response getNpmHostedRepository(@PathVariable("repositoryName") String name) {
        return this.npmRepositoryService.getNpmHostedRepository(name);
    }

    @Operation(summary = "NPM Proxy 저장소 조회")
    @GetMapping("repository/npm/proxy/{repositoryName}")
    public NpmProxyDto.Response getNpmProxyRepository(@PathVariable("repositoryName") String name) {
        return this.npmRepositoryService.getNpmProxyRepository(name);
    }

    @Operation(summary = "NPM Group 저장소 생성")
    @PostMapping("repository/npm/group")
    public Integer createNpmGroupRepository(@RequestBody NpmGroupDto.Request data) {
        return this.npmRepositoryService.createNpmGroupRepository(data);
    }

    @Operation(summary = "NPM Hosted 저장소 생성")
    @PostMapping("repository/npm/hosted")
    public Integer createNpmHostedRepository(@RequestBody NpmHostedDto.Request data) {
        return this.npmRepositoryService.createNpmHostedRepository(data);
    }

    @Operation(summary = "NPM Proxy 저장소 생성")
    @PostMapping("repository/npm/proxy")
    public Integer createNpmProxyRepository(@RequestBody NpmProxyDto.Request data) {
        return this.npmRepositoryService.createNpmProxyRepository(data);
    }

    @Operation(summary = "NPM Group 저장소 갱신")
    @PutMapping("repository/npm/group/{repositoryName}")
    public Integer updateNpmGroupRepository(@PathVariable("repositoryName") String name, @RequestBody NpmGroupDto.Request data) {
        return this.npmRepositoryService.updateNpmGroupRepository(name, data);
    }

    @Operation(summary = "NPM Hosted 저장소 갱신")
    @PutMapping("repository/npm/hosted/{repositoryName}")
    public Integer updateNpmHostedRepository(@PathVariable("repositoryName") String name, @RequestBody NpmHostedDto.Request data) {
        return this.npmRepositoryService.updateNpmHostedRepository(name, data);
    }

    @Operation(summary = "NPM Proxy 저장소 갱신")
    @PutMapping("repository/npm/proxy/{repositoryName}")
    public Integer updateNpmProxyRepository(@PathVariable("repositoryName") String name, @RequestBody NpmProxyDto.Request data) {
        return this.npmRepositoryService.updateNpmProxyRepository(name, data);
    }
}

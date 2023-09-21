package com.osckorea.openmsa.nexus.repository.raw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.nexus.repository.raw.service.RawRepositoryService;
import com.osckorea.openmsa.nexus.repository.raw.dto.RawGroupDto;
import com.osckorea.openmsa.nexus.repository.raw.dto.RawHostedDto;
import com.osckorea.openmsa.nexus.repository.raw.dto.RawProxyDto;

import lombok.RequiredArgsConstructor;

@Tag(name = "Raw 저장소 API", description = "Nexus Raw 저장소 RESTful CRU 관련 API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class RawRepositoryController {
    private final RawRepositoryService rawRepositoryService;

    @Operation(summary = "Raw Group 저장소 조회")
    @GetMapping("repository/raw/group/{repositoryName}")
    public RawGroupDto.Response getRawGroupRepository(@PathVariable("repositoryName") String name) {
        return this.rawRepositoryService.getRawGroupRepository(name);
    }

    @Operation(summary = "Raw Hosted 저장소 조회")
    @GetMapping("repository/raw/hosted/{repositoryName}")
    public RawHostedDto.Response getRawHostedRepository(@PathVariable("repositoryName") String name) {
        return this.rawRepositoryService.getRawHostedRepository(name);
    }

    @Operation(summary = "Raw Proxy 저장소 조회")
    @GetMapping("repository/raw/proxy/{repositoryName}")
    public RawProxyDto.Response getRawProxyRepository(@PathVariable("repositoryName") String name) {
        return this.rawRepositoryService.getRawProxyRepository(name);
    }

    @Operation(summary = "Raw Group 저장소 생성")
    @PostMapping("repository/raw/group")
    public Integer createRawGroupRepository(@RequestBody RawGroupDto.Request data) {
        return this.rawRepositoryService.createRawGroupRepository(data);
    }

    @Operation(summary = "Raw Hosted 저장소 생성")
    @PostMapping("repository/raw/hosted")
    public Integer createRawHostedRepository(@RequestBody RawHostedDto.Request data) {
        return this.rawRepositoryService.createRawHostedRepository(data);
    }

    @Operation(summary = "Raw Proxy 저장소 생성")
    @PostMapping("repository/raw/proxy")
    public Integer createRawProxyRepository(@RequestBody RawProxyDto.Request data) {
        return this.rawRepositoryService.createRawProxyRepository(data);
    }

    @Operation(summary = "Raw Group 저장소 갱신")
    @PutMapping("repository/raw/group/{repositoryName}")
    public Integer updateRawGroupRepository(@PathVariable("repositoryName") String name, @RequestBody RawGroupDto.Request data) {
        return this.rawRepositoryService.updateRawGroupRepository(name, data);
    }

    @Operation(summary = "Raw Hosted 저장소 갱신")
    @PutMapping("repository/raw/hosted/{repositoryName}")
    public Integer updateRawHostedRepository(@PathVariable("repositoryName") String name, @RequestBody RawHostedDto.Request data) {
        return this.rawRepositoryService.updateRawHostedRepository(name, data);
    }

    @Operation(summary = "Raw Proxy 저장소 갱신")
    @PutMapping("repository/raw/proxy/{repositoryName}")
    public Integer updateRawProxyRepository(@PathVariable("repositoryName") String name, @RequestBody RawProxyDto.Request data) {
        return this.rawRepositoryService.updateRawProxyRepository(name, data);
    }
}

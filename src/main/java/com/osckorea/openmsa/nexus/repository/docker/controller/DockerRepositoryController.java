package com.osckorea.openmsa.nexus.repository.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.nexus.repository.docker.dto.DockerGroupDto;
import com.osckorea.openmsa.nexus.repository.docker.dto.DockerHostedDto;
import com.osckorea.openmsa.nexus.repository.docker.dto.DockerProxyDto;
import com.osckorea.openmsa.nexus.repository.docker.service.DockerRepositoryService;

import lombok.RequiredArgsConstructor;

@Tag(name = "Docker 저장소 API", description = "Nexus Docker 저장소 RESTful CRU 관련 API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class DockerRepositoryController {
    private final DockerRepositoryService dockerRepositoryService;

    @Operation(summary = "Docker Group 저장소 조회")
    @GetMapping("repository/docker/group/{repositoryName}")
    public DockerGroupDto.Response getDockerGroupRepository(@PathVariable("repositoryName") String name) {
        return this.dockerRepositoryService.getDockerGroupRepository(name);
    }

    @Operation(summary = "Docker Hosted 저장소 조회")
    @GetMapping("repository/docker/hosted/{repositoryName}")
    public DockerHostedDto.Response getDockerHostedRepository(@PathVariable("repositoryName") String name) {
        return this.dockerRepositoryService.getDockerHostedRepository(name);
    }

    @Operation(summary = "Docker Proxy 저장소 조회")
    @GetMapping("repository/docker/proxy/{repositoryName}")
    public DockerProxyDto.Response getDockerProxyRepository(@PathVariable("repositoryName") String name) {
        return this.dockerRepositoryService.getDockerProxyRepository(name);
    }

    @Operation(summary = "Docker Group 저장소 생성")
    @PostMapping("repository/docker/group")
    public Integer createDockerGroupRepository(@RequestBody DockerGroupDto.Request data) {
        return this.dockerRepositoryService.createDockerGroupRepository(data);
    }

    @Operation(summary = "Docker Hosted 저장소 생성")
    @PostMapping("repository/docker/hosted")
    public Integer createDockerHostedRepository(@RequestBody DockerHostedDto.Request data) {
        return this.dockerRepositoryService.createDockerHostedRepository(data);
    }

    @Operation(summary = "Docker Proxy 저장소 조회")
    @PostMapping("repository/docker/proxy")
    public Integer createDockerProxyRepository(@RequestBody DockerProxyDto.Request data) {
        return this.dockerRepositoryService.createDockerProxyRepository(data);
    }

    @Operation(summary = "Docker Group 저장소 갱신")
    @PutMapping("repository/docker/group/{repositoryName}")
    public Integer updateDockerGroupRepository(@PathVariable("repositoryName") String name, @RequestBody DockerGroupDto.Request data) {
        return this.dockerRepositoryService.updateDockerGroupRepository(name, data);
    }

    @Operation(summary = "Docker Hosted 저장소 갱신")
    @PutMapping("repository/docker/hosted/{repositoryName}")
    public Integer updateDockerHostedRepository(@PathVariable("repositoryName") String name, @RequestBody DockerHostedDto.Request data) {
        return this.dockerRepositoryService.updateDockerHostedRepository(name, data);
    }

    @Operation(summary = "Docker Proxy 저장소 갱신")
    @PutMapping("repository/docker/proxy/{repositoryName}")
    public Integer updateDockerProxyRepository(@PathVariable("repositoryName") String name, @RequestBody DockerProxyDto.Request data) {
        return this.dockerRepositoryService.updateDockerProxyRepository(name, data);
    }
}

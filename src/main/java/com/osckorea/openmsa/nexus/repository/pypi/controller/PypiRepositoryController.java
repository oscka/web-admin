package com.osckorea.openmsa.nexus.repository.pypi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.nexus.repository.pypi.service.PypiRepositoryService;
import com.osckorea.openmsa.nexus.repository.pypi.dto.PypiGroupDto;
import com.osckorea.openmsa.nexus.repository.pypi.dto.PypiHostedDto;
import com.osckorea.openmsa.nexus.repository.pypi.dto.PypiProxyDto;

import lombok.RequiredArgsConstructor;

@Tag(name = "PyPi 저장소 API", description = "Nexus PyPi 저장소 RESTful CRU 관련 API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class PypiRepositoryController {
    private final PypiRepositoryService pypiRepositoryService;

    @Operation(summary = "PyPi Group 저장소 조회")
    @GetMapping("repository/pypi/group/{repositoryName}")
    public PypiGroupDto.Response getPypiGroupRepository(@PathVariable("repositoryName") String name) {
        return this.pypiRepositoryService.getPypiGroupRepository(name);
    }

    @Operation(summary = "PyPi Hosted 저장소 조회")
    @GetMapping("repository/pypi/hosted/{repositoryName}")
    public PypiHostedDto.Response getPypiHostedRepository(@PathVariable("repositoryName") String name) {
        return this.pypiRepositoryService.getPypiHostedRepository(name);
    }

    @Operation(summary = "PyPi Proxy 저장소 조회")
    @GetMapping("repository/pypi/proxy/{repositoryName}")
    public PypiProxyDto.Response getPypiProxyRepository(@PathVariable("repositoryName") String name) {
        return this.pypiRepositoryService.getPypiProxyRepository(name);
    }

    @Operation(summary = "PyPi Group 저장소 생성")
    @PostMapping("repository/pypi/group")
    public Integer createPypiGroupRepository(@RequestBody PypiGroupDto.Request data) {
        return this.pypiRepositoryService.createPypiGroupRepository(data);
    }

    @Operation(summary = "PyPi Hosted 저장소 생성")
    @PostMapping("repository/pypi/hosted")
    public Integer createPypiHostedRepository(@RequestBody PypiHostedDto.Request data) {
        return this.pypiRepositoryService.createPypiHostedRepository(data);
    }

    @Operation(summary = "PyPi Proxy 저장소 생성")
    @PostMapping("repository/pypi/proxy")
    public Integer createPypiProxyRepository(@RequestBody PypiProxyDto.Request data) {
        return this.pypiRepositoryService.createPypiProxyRepository(data);
    }

    @Operation(summary = "PyPi Group 저장소 갱신")
    @PutMapping("repository/pypi/group/{repositoryName}")
    public Integer updatePypiGroupRepository(@PathVariable("repositoryName") String name, @RequestBody PypiGroupDto.Request data) {
        return this.pypiRepositoryService.updatePypiGroupRepository(name, data);
    }

    @Operation(summary = "PyPi Hosted 저장소 갱신")
    @PutMapping("repository/pypi/hosted/{repositoryName}")
    public Integer updatePypiHostedRepository(@PathVariable("repositoryName") String name, @RequestBody PypiHostedDto.Request data) {
        return this.pypiRepositoryService.updatePypiHostedRepository(name, data);
    }

    @Operation(summary = "PyPi Proxy 저장소 갱신")
    @PutMapping("repository/pypi/proxy/{repositoryName}")
    public Integer updatePypiProxyRepository(@PathVariable("repositoryName") String name, @RequestBody PypiProxyDto.Request data) {
        return this.pypiRepositoryService.updatePypiProxyRepository(name, data);
    }
}

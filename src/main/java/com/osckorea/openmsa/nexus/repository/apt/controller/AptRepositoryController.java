package com.osckorea.openmsa.nexus.repository.apt.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.nexus.repository.apt.service.AptRepositoryService;

import com.osckorea.openmsa.nexus.repository.apt.dto.AptGroupDto;
import com.osckorea.openmsa.nexus.repository.apt.dto.AptHostedDto;
import com.osckorea.openmsa.nexus.repository.apt.dto.AptProxyDto;

import lombok.RequiredArgsConstructor;

@Tag(name = "APT 저장소 API", description = "Nexus APT 저장소 RESTful CRU 관련 API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class AptRepositoryController {
    private final AptRepositoryService aptRepositoryService;

    @Operation(
        summary = "APT Group 저장소 조회",         
        responses = {@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AptGroupDto.Response.class)))})
    @GetMapping("repository/apt/group/{repositoryName}")
    public AptGroupDto.Response getAptGroupRepository(@PathVariable("repositoryName") String name) {
        return this.aptRepositoryService.getAptGroupRepository(name);
    }

    @Operation(
        summary = "APT Hosted 저장소 조회",
        responses = {@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AptHostedDto.Response.class)))})
    @GetMapping("repository/apt/hosted/{repositoryName}")
    public AptHostedDto.Response getAptHostedRepository(@PathVariable("repositoryName") String name) {
        return this.aptRepositoryService.getAptHostedRepository(name);
    }

    @Operation(
        summary = "APT Proxy 저장소 조회",
        responses = {@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AptProxyDto.Response.class)))})
    @GetMapping("repository/apt/proxy/{repositoryName}")
    public AptProxyDto.Response getAptProxyRepository(@PathVariable("repositoryName") String name) {
        return this.aptRepositoryService.getAptProxyRepository(name);
    }

    @Operation(summary = "APT Group 저장소 생성", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AptGroupDto.class))))
    @PostMapping("repository/apt/group")
    public Integer createAptGroupRepository(@RequestBody AptGroupDto.Request data) {
        return this.aptRepositoryService.createAptGroupRepository(data);
    }

    @Operation(summary = "APT Hosted 저장소 생성", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AptHostedDto.class))))
    @PostMapping("repository/apt/hosted")
    public Integer createAptHostedRepository(@RequestBody AptHostedDto.Request data) {
        return this.aptRepositoryService.createAptHostedRepository(data);
    }

    @Operation(summary = "APT Proxy 저장소 생성", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AptProxyDto.class))))
    @PostMapping("repository/apt/proxy")
    public Integer createAptProxyRepository(@RequestBody AptProxyDto.Request data) {
        return this.aptRepositoryService.createAptProxyRepository(data);
    }

    @Operation(summary = "APT Group 저장소 갱신", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AptGroupDto.class))))
    @PutMapping("repository/apt/group/{repositoryName}")
    public Integer updateAptGroupRepository(@PathVariable("repositoryName") String name, @RequestBody AptGroupDto.Request data) {
        return this.aptRepositoryService.updateAptGroupRepository(name, data);
    }

    @Operation(summary = "APT Hosted 저장소 갱신", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AptHostedDto.class))))
    @PutMapping("repository/apt/hosted/{repositoryName}")
    public Integer updateAptHostedRepository(@PathVariable("repositoryName") String name, @RequestBody AptHostedDto.Request data) {
        return this.aptRepositoryService.updateAptHostedRepository(name, data);
    }

    @Operation(summary = "APT Proxy 저장소 갱신", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AptProxyDto.Request.class))))
    @PutMapping("repository/apt/proxy/{repositoryName}")
    public Integer updateAptProxyRepository(@PathVariable("repositoryName") String name, @RequestBody AptProxyDto.Request data) {
        return this.aptRepositoryService.updateAptProxyRepository(name, data);
    }
}

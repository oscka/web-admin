package com.osckorea.openmsa.nexus.repository.common.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.nexus.repository.common.dto.RepositoryDto;
import com.osckorea.openmsa.nexus.repository.common.service.RepositoryExternalService;
import com.osckorea.openmsa.nexus.repository.common.service.RepositoryService;

import lombok.RequiredArgsConstructor;

@Tag(name = "저장소 공통 API", description = "Nexus 저장소 공통 Restful API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class RepositoryController {
    private final RepositoryExternalService repositoryExternalService;
    private final RepositoryService repositoryService;

    @Operation(summary = "저장소 별 상세정보 조회")
    @GetMapping("repository/references")
    public RepositoryDto.Response[] getRepositoryReferences() {
        return this.repositoryExternalService.getRepositoryReferences();
    }

    @Operation(summary = "특정 저장소 삭제")
    @DeleteMapping("repository/{repositoryName}")
    public Integer deleteRepository(@PathVariable("repositoryName") String name) {
        return this.repositoryService.deleteRepository(name);
    }
}

package com.osckorea.openmsa.admin.browse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osckorea.openmsa.admin.browse.dto.BrowseTreeNodeDto;
import com.osckorea.openmsa.admin.browse.service.BrowseExternalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Browse API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class BrowseController {
    private final BrowseExternalService browseExternalService;
    
    @Operation(summary = "하위 Node 조회 API 입니다.")
    @GetMapping("browse/{repositoryName}/nodes")
    public BrowseTreeNodeDto.Response[] getBrowseTreeNodes(@PathVariable("repositoryName") String name, @RequestParam(value = "nodeId", required = false) String nodeId) {
        if(nodeId == null) {
            return this.browseExternalService.getBrowseTreeNodes(name, "/");
        }

        return this.browseExternalService.getBrowseTreeNodes(name, nodeId);
    }
}

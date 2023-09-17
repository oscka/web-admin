package com.osckorea.openmsa.admin.search.maven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.admin.search.maven.dto.SearchMavenAssetDto;
import com.osckorea.openmsa.admin.search.maven.dto.SearchMavenComponentDto;
import com.osckorea.openmsa.admin.search.maven.service.MavenSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Maven 저장소 검색 API", description = "Maven 저장소의 Component 혹은 Asset 검색 API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class MavenSearchController {
    private final MavenSearchService mavenSearchService;

    @Operation(summary = "Maven 저장소 Component 목록 조회")
    @ApiResponses(value = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = SearchMavenComponentDto.class))))
    @GetMapping("search/maven2/{repositoryName}/components")
    public SearchMavenComponentDto searchMavenComponents(@PathVariable("repositoryName") String name, @RequestParam(value = "keyword", required = false) String keyword) {
        return this.mavenSearchService.searchMavenComponents(name, keyword);
    }

    @Operation(summary = "Maven 저장소 Asset 목록 조회")
    @ApiResponses(value = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = SearchMavenAssetDto.class))))
    @GetMapping("search/maven2/{repositoryName}/assets")
    public SearchMavenAssetDto searchMavenAssets(@PathVariable("repositoryName") String name, @RequestParam(value = "keyword", required = false) String keyword) {
        return this.mavenSearchService.searchMavenAssets(name, keyword);
    }
}

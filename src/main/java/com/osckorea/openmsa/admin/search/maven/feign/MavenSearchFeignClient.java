package com.osckorea.openmsa.admin.search.maven.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.search.maven.dto.SearchMavenAssetDto;
import com.osckorea.openmsa.admin.search.maven.dto.SearchMavenComponentDto;

@FeignClient(name = "NEXUS-MAVEN-SEARCH-PUBLIC-CLIENT", url = "${api.nexus.public}/search", configuration = {NexusFeignClientConfiguration.class})
public interface MavenSearchFeignClient {
    @GetMapping
    public SearchMavenComponentDto searchMavenComponents(
        @RequestParam(value = "continuationToken", required = false) String continuationToken,
        @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
        @RequestParam(value = "repository", required = false) String repositoryName,
        @RequestParam(value = "q", required = false) String query
    );

    @GetMapping("assets")
    public SearchMavenAssetDto searchMavenAssets(
        @RequestParam(value = "continuationToken", required = false) String continuationToken,
        @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
        @RequestParam(value = "repository", required = false) String repositoryName,
        @RequestParam(value = "q", required = false) String query
    );
}

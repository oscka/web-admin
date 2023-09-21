package com.osckorea.openmsa.nexus.asset.maven.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.osckorea.openmsa.nexus.asset.maven.dto.MavenAssetPagingDto;
import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;

@FeignClient(name = "NEXUS-MAVEN-ASSET-PUBLIC-CLIENT", url = "${api.nexus.public}/assets", configuration = {NexusApiFeignClientConfiguration.class})
public interface MavenAssetFeignClient {
    @GetMapping(params = {"repository"})
    public MavenAssetPagingDto getAssetList(@RequestParam("repository") String repository);

    @GetMapping(params = {"continuationToken", "repository"})
    public MavenAssetPagingDto getAssetList(@RequestParam("continuationToken") String continuationToken, @RequestParam("repository") String repository);
}
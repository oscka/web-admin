package com.osckorea.openmsa.admin.nexus.feign.asset;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.nexus.dto.asset.AssetDto;

@FeignClient(name = "NEXUS-PUBLIC-ASSET-CLIENT", url = "${api.nexus.public}/assets", configuration = {NexusFeignClientConfiguration.class})
public interface NexusAssetPublicFeignClient {
    @GetMapping(params = {"repository"})
    public AssetDto getAssetList(@RequestParam("repository") String repository);

    @GetMapping(params = {"continuationToken", "repository"})
    public AssetDto getAssetList(@RequestParam("continuationToken") String continuationToken, @RequestParam("repository") String repository);
}

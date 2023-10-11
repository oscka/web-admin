package com.osckorea.openmsa.nexus.asset.common.feign;

import java.net.URI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;

@FeignClient(name = "NEXUS-ASSET-DOWNLOAD-CLIENT", url =  "http://nexus-api-placeholder", configuration = {NexusApiFeignClientConfiguration.class})
public interface AssetDownloadFeignClient {
    @GetMapping
    public ResponseEntity<byte[]> assetDownload(URI url);
}

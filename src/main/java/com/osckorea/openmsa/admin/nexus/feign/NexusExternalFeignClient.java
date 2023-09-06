package com.osckorea.openmsa.admin.nexus.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.nexus.dto.external.ExternalApiRequestDto;
import com.osckorea.openmsa.admin.nexus.dto.external.ExternalApiResponseDto;

@FeignClient(name = "NEXUS-EXTERNAL-CLIENT", url = "${api.nexus.external}", configuration = {NexusFeignClientConfiguration.class})
public interface NexusExternalFeignClient {
    @PostMapping()
    public ExternalApiResponseDto<?> requestExternal(@RequestBody ExternalApiRequestDto<?> data);
}

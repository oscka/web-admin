package com.osckorea.openmsa.nexus.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;
import com.osckorea.openmsa.nexus.common.dto.ExternalApiRequestDto;
import com.osckorea.openmsa.nexus.common.dto.ExternalApiResponseDto;

@FeignClient(name = "NEXUS-EXTERNAL-CLIENT", url = "${api.nexus.external}", configuration = {NexusApiFeignClientConfiguration.class})
public interface NexusExternalFeignClient {
    @PostMapping()
    public ExternalApiResponseDto<?> request(@RequestBody ExternalApiRequestDto<?> data);
}

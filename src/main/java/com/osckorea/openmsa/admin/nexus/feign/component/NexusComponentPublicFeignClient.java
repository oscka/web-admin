package com.osckorea.openmsa.admin.nexus.feign.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.nexus.dto.component.ComponentDto;

@FeignClient(name = "NEXUS-PUBLIC-COMPONENT-CLIENT", url = "${api.nexus.public}/components", configuration = {NexusFeignClientConfiguration.class})
public interface NexusComponentPublicFeignClient {
    @GetMapping(params = {"repository"})
    public ComponentDto getComponentList(@RequestParam("repository") String repository);

    @GetMapping(params = {"continuationToken" ,"repository"})
    public ComponentDto getComponentList(@RequestParam("continuationToken") String continuationToken, @RequestParam("repository") String repository);
}

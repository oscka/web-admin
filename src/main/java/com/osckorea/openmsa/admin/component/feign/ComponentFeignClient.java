package com.osckorea.openmsa.admin.component.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.osckorea.openmsa.admin.component.dto.ComponentDto;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;

@FeignClient(name = "NEXUS-COMPONENT-PUBLIC-CLIENT", url = "${api.nexus.public}/components", configuration = {NexusFeignClientConfiguration.class})
public interface ComponentFeignClient {
    @GetMapping(params = {"repository"})
    public ComponentDto getComponentList(@RequestParam("repository") String repository);

    @GetMapping(params = {"continuationToken" ,"repository"})
    public ComponentDto getComponentList(@RequestParam("continuationToken") String continuationToken, @RequestParam("repository") String repository);
}
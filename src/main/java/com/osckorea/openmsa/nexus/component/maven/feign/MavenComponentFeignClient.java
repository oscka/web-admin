package com.osckorea.openmsa.nexus.component.maven.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;
import com.osckorea.openmsa.nexus.component.maven.dto.MavenComponentPagingDto;

@FeignClient(name = "NEXUS-MAVEN-COMPONENT-PUBLIC-CLIENT", url = "${api.nexus.public}/components", configuration = {NexusApiFeignClientConfiguration.class})
public interface MavenComponentFeignClient {
    @GetMapping(params = {"repository"})
    public MavenComponentPagingDto getComponentList(@RequestParam("repository") String repository);

    @GetMapping(params = {"continuationToken" ,"repository"})
    public MavenComponentPagingDto getComponentList(@RequestParam("continuationToken") String continuationToken, @RequestParam("repository") String repository);
}

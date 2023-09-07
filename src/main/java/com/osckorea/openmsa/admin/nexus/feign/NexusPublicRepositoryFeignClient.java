package com.osckorea.openmsa.admin.nexus.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;

@FeignClient(name = "NEXUS-PUBLIC-REPOSITORY-CLIENT", url = "${api.nexus.public}", configuration = {NexusFeignClientConfiguration.class})
public interface NexusPublicRepositoryFeignClient {
    @GetMapping("/repositories/{repositoryName}")
    public Object getRepositoryDetail(@PathVariable("repositoryName") String name);

    @GetMapping("/repositorySettings")
    public Object[] getRepositorySettings();
    
    @PostMapping("/repositories/maven/group")
    public String createMavenGroup();

    @PostMapping("/repositories/maven/hosted")
    public String createMavenHosted();

    @PostMapping("/repositories/maven/proxy")
    public String createMavenProxy(@RequestBody String data);

    @DeleteMapping("/repositories/{repositoryName}")
    public String deleteRepository(@PathVariable("repositoryName") String name);
}

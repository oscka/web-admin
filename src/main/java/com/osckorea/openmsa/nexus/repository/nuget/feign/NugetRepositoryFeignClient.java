package com.osckorea.openmsa.nexus.repository.nuget.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.osckorea.openmsa.nexus.repository.nuget.dto.NugetGroupDto;
import com.osckorea.openmsa.nexus.repository.nuget.dto.NugetHostedDto;
import com.osckorea.openmsa.nexus.repository.nuget.dto.NugetProxyDto;
import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;

@FeignClient(name = "NEXUS-NUGET-REPOSITORY-PUBLIC-CLIENT", url = "${api.nexus.public}/repositories/nuget", configuration = {NexusApiFeignClientConfiguration.class})
public interface NugetRepositoryFeignClient {
    // Nuget - Group
    @GetMapping("group/{repositoryName}")
    public ResponseEntity<NugetGroupDto.Response> getNugetGroupRepository(@PathVariable("repositoryName") String name);

    @PostMapping("group")
    public ResponseEntity<Void> createNugetGroupRepository(@RequestBody NugetGroupDto.Request data);

    @PutMapping("group/{repositoryName}")
    public ResponseEntity<Void> updateNugetGroupRepository(@PathVariable("repositoryName") String name, @RequestBody NugetGroupDto.Request data);

    // Nuget - Hosted
    @GetMapping("hosted/{repositoryName}")
    public ResponseEntity<NugetHostedDto.Response> getNugetHostedRepository(@PathVariable("repositoryName") String name);

    @PostMapping("hosted")
    public ResponseEntity<Void> createNugetHostedRepository(@RequestBody NugetHostedDto.Request data);

    @PutMapping("hosted/{repositoryName}")
    public ResponseEntity<Void> updateNugetHostedRepository(@PathVariable("repositoryName") String name, @RequestBody NugetHostedDto.Request data);

    // Nuget - Proxy
    @GetMapping("proxy/{repositoryName}")
    public ResponseEntity<NugetProxyDto.Response> getNugetProxyRepository(@PathVariable("repositoryName") String name);

    @PostMapping("proxy")
    public ResponseEntity<Void> createNugetProxyRepository(@RequestBody NugetProxyDto.Request data);

    @PutMapping("proxy/{repositoryName}")
    public ResponseEntity<Void> updateNugetProxyRepository(@PathVariable("repositoryName") String name, @RequestBody NugetProxyDto.Request data);
}

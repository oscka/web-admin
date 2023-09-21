package com.osckorea.openmsa.nexus.repository.npm.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.osckorea.openmsa.nexus.repository.npm.dto.NpmGroupDto;
import com.osckorea.openmsa.nexus.repository.npm.dto.NpmHostedDto;
import com.osckorea.openmsa.nexus.repository.npm.dto.NpmProxyDto;
import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;

@FeignClient(name = "NEXUS-NPM-REPOSITORY-PUBLIC-CLIENT", url = "${api.nexus.public}/repositories/npm", configuration = {NexusApiFeignClientConfiguration.class})
public interface NpmRepositoryFeignClient {
    // Npm - Group
    @GetMapping("group/{repositoryName}")
    public ResponseEntity<NpmGroupDto.Response> getNpmGroupRepository(@PathVariable("repositoryName") String name);

    @PostMapping("group")
    public ResponseEntity<Void> createNpmGroupRepository(@RequestBody NpmGroupDto.Request data);

    @PutMapping("group/{repositoryName}")
    public ResponseEntity<Void> updateNpmGroupRepository(@PathVariable("repositoryName") String name, @RequestBody NpmGroupDto.Request data);

    // Npm - Hosted
    @GetMapping("hosted/{repositoryName}")
    public ResponseEntity<NpmHostedDto.Response> getNpmHostedRepository(@PathVariable("repositoryName") String name);

    @PostMapping("hosted")
    public ResponseEntity<Void> createNpmHostedRepository(@RequestBody NpmHostedDto.Request data);

    @PutMapping("hosted/{repositoryName}")
    public ResponseEntity<Void> updateNpmHostedRepository(@PathVariable("repositoryName") String name, @RequestBody NpmHostedDto.Request data);

    // Npm - Proxy
    @GetMapping("proxy/{repositoryName}")
    public ResponseEntity<NpmProxyDto.Response> getNpmProxyRepository(@PathVariable("repositoryName") String name);

    @PostMapping("proxy")
    public ResponseEntity<Void> createNpmProxyRepository(@RequestBody NpmProxyDto.Request data);

    @PutMapping("proxy/{repositoryName}")
    public ResponseEntity<Void> updateNpmProxyRepository(@PathVariable("repositoryName") String name, @RequestBody NpmProxyDto.Request data);
}

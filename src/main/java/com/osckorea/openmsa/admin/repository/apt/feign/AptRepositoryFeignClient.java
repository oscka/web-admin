package com.osckorea.openmsa.admin.repository.apt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.repository.apt.dto.AptGroupDto;
import com.osckorea.openmsa.admin.repository.apt.dto.AptHostedDto;
import com.osckorea.openmsa.admin.repository.apt.dto.AptProxyDto;

@FeignClient(name = "NEXUS-APT-REPOSITORY-PUBLIC-CLIENT", url = "${api.nexus.public}/repositories/apt", configuration = {NexusFeignClientConfiguration.class})
public interface AptRepositoryFeignClient {
    // Apt - Group
    @GetMapping("group/{repositoryName}")
    public ResponseEntity<AptGroupDto.Response> getAptGroupRepository(@PathVariable("repositoryName") String name);

    @PostMapping("group")
    public ResponseEntity<Void> createAptGroupRepository(@RequestBody AptGroupDto.Request data);

    @PutMapping("group/{repositoryName}")
    public ResponseEntity<Void> updateAptGroupRepository(@PathVariable("repositoryName") String name, @RequestBody AptGroupDto.Request data);

    // Apt - Hosted
    @GetMapping("hosted/{repositoryName}")
    public ResponseEntity<AptHostedDto.Response> getAptHostedRepository(@PathVariable("repositoryName") String name);

    @PostMapping("hosted")
    public ResponseEntity<Void> createAptHostedRepository(@RequestBody AptHostedDto.Request data);

    @PutMapping("hosted/{repositoryName}")
    public ResponseEntity<Void> updateAptHostedRepository(@PathVariable("repositoryName") String name, @RequestBody AptHostedDto.Request data);

    // Apt - Proxy
    @GetMapping("proxy/{repositoryName}")
    public ResponseEntity<AptProxyDto.Response> getAptProxyRepository(@PathVariable("repositoryName") String name);

    @PostMapping("proxy")
    public ResponseEntity<Void> createAptProxyRepository(@RequestBody AptProxyDto.Request data);

    @PutMapping("proxy/{repositoryName}")
    public ResponseEntity<Void> updateAptProxyRepository(@PathVariable("repositoryName") String name, @RequestBody AptProxyDto.Request data);
}

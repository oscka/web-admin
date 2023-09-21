package com.osckorea.openmsa.nexus.repository.raw.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.osckorea.openmsa.nexus.repository.raw.dto.RawGroupDto;
import com.osckorea.openmsa.nexus.repository.raw.dto.RawHostedDto;
import com.osckorea.openmsa.nexus.repository.raw.dto.RawProxyDto;
import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;


@FeignClient(name = "NEXUS-RAW-REPOSITORY-PUBLIC-CLIENT", url = "${api.nexus.public}/repositories/raw", configuration = {NexusApiFeignClientConfiguration.class})
public interface RawRepositoryFeignClient {
    // Raw - Group
    @GetMapping("group/{repositoryName}")
    public ResponseEntity<RawGroupDto.Response> getRawGroupRepository(@PathVariable("repositoryName") String name);

    @PostMapping("group")
    public ResponseEntity<Void> createRawGroupRepository(@RequestBody RawGroupDto.Request data);

    @PutMapping("group/{repositoryName}")
    public ResponseEntity<Void> updateRawGroupRepository(@PathVariable("repositoryName") String name, @RequestBody RawGroupDto.Request data);

    // Raw - Hosted
    @GetMapping("hosted/{repositoryName}")
    public ResponseEntity<RawHostedDto.Response> getRawHostedRepository(@PathVariable("repositoryName") String name);

    @PostMapping("hosted")
    public ResponseEntity<Void> createRawHostedRepository(@RequestBody RawHostedDto.Request data);

    @PutMapping("hosted/{repositoryName}")
    public ResponseEntity<Void> updateRawHostedRepository(@PathVariable("repositoryName") String name, @RequestBody RawHostedDto.Request data);

    // Raw - Proxy
    @GetMapping("proxy/{repositoryName}")
    public ResponseEntity<RawProxyDto.Response> getRawProxyRepository(@PathVariable("repositoryName") String name);

    @PostMapping("proxy")
    public ResponseEntity<Void> createRawProxyRepository(@RequestBody RawProxyDto.Request data);

    @PutMapping("proxy/{repositoryName}")
    public ResponseEntity<Void> updateRawProxyRepository(@PathVariable("repositoryName") String name, @RequestBody RawProxyDto.Request data);
}

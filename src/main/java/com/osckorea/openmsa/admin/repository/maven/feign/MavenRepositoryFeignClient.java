package com.osckorea.openmsa.admin.repository.maven.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.repository.maven.dto.MavenGroupDto;
import com.osckorea.openmsa.admin.repository.maven.dto.MavenHostedDto;
import com.osckorea.openmsa.admin.repository.maven.dto.MavenProxyDto;

@FeignClient(name = "NEXUS-MAVEN-REPOSITORY-PUBLIC-CLIENT", url = "${api.nexus.public}/repositories/maven", configuration = {NexusFeignClientConfiguration.class})
public interface MavenRepositoryFeignClient {
    // Maven - Group
    @GetMapping("group/{repositoryName}")
    public ResponseEntity<MavenGroupDto.Response> getMavenGroupRepository(@PathVariable("repositoryName") String name);

    @PostMapping("group")
    public ResponseEntity<Void> createMavenGroupRepository(@RequestBody MavenGroupDto.Request data);

    @PutMapping("group/{repositoryName}")
    public ResponseEntity<Void> updateMavenGroupRepository(@PathVariable("repositoryName") String name, @RequestBody MavenGroupDto.Request data);

    // Maven - Hosted
    @GetMapping("hosted/{repositoryName}")
    public ResponseEntity<MavenHostedDto.Response> getMavenHostedRepository(@PathVariable("repositoryName") String name);

    @PostMapping("hosted")
    public ResponseEntity<Void> createMavenHostedRepository(@RequestBody MavenHostedDto.Request data);

    @PutMapping("hosted/{repositoryName}")
    public ResponseEntity<Void> updateMavenHostedRepository(@PathVariable("repositoryName") String name, @RequestBody MavenHostedDto.Request data);

    // Maven - Proxy
    @GetMapping("proxy/{repositoryName}")
    public ResponseEntity<MavenProxyDto.Response> getMavenProxyRepository(@PathVariable("repositoryName") String name);

    @PostMapping("proxy")
    public ResponseEntity<Void> createMavenProxyRepository(@RequestBody MavenProxyDto.Request data);

    @PutMapping("proxy/{repositoryName}")
    public ResponseEntity<Void> updateMavenProxyRepository(@PathVariable("repositoryName") String name, @RequestBody MavenProxyDto.Request data);
}

package com.osckorea.openmsa.admin.nexus.feign.repository.maven;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.nexus.dto.repository.maven.MavenHostedDto;
import com.osckorea.openmsa.admin.nexus.dto.repository.maven.MavenProxyDto;
import com.osckorea.openmsa.admin.nexus.dto.repository.GroupDto;

@FeignClient(name = "NEXUS-MAVEN-REPOSITOY-PUBLIC-CLIENT", url = "${api.nexus.public}/repositories/maven", configuration = {NexusFeignClientConfiguration.class})
public interface NexusMavenRepositoryPublicFeignClient {

    // Maven - Group
    @GetMapping("group/{repositoryName}")
    public ResponseEntity<GroupDto.Response> getMavenGroupRepository(@PathVariable("repositoryName") String name);

    @PostMapping("group")
    public ResponseEntity<Void> createMavenGroupRepository(@RequestBody GroupDto.Request data);

    @PutMapping("group/{repositoryName}")
    public ResponseEntity<Void> updateMavenGroupRepository(
        @PathVariable("repositoryName") String name,
        @RequestBody GroupDto.Request data
    );

    // Maven - Hosted
    @GetMapping("hosted/{repositoryName}")
    public ResponseEntity<MavenHostedDto.Response> getMavenHostedRepository(@PathVariable("repositoryName") String name);

    @PostMapping("hosted")
    public ResponseEntity<Void> createMavenHostedRepository(@RequestBody MavenHostedDto.Request data);

    @PutMapping("hosted/{repositoryName}")
    public ResponseEntity<Void> updateMavenHostedRepository(
        @PathVariable("repositoryName") String name,
        @RequestBody MavenHostedDto.Request data
    );

    // Maven - Proxy
    @GetMapping("proxy/{repositoryName}")
    public ResponseEntity<MavenProxyDto.Response> getMavenProxyRepository(@PathVariable("repositoryName") String name);

    @PostMapping("proxy")
    public ResponseEntity<Void> createMavenProxyRepository(@RequestBody MavenProxyDto.Request data);

    @PutMapping("proxy/{repositoryName}")
    public ResponseEntity<Void> updateMavenProxyRepository(
        @PathVariable("repositoryName") String name,
        @RequestBody MavenProxyDto.Request data
    );
}
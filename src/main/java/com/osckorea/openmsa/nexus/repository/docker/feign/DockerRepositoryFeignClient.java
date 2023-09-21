package com.osckorea.openmsa.nexus.repository.docker.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.osckorea.openmsa.nexus.repository.docker.dto.DockerGroupDto;
import com.osckorea.openmsa.nexus.repository.docker.dto.DockerHostedDto;
import com.osckorea.openmsa.nexus.repository.docker.dto.DockerProxyDto;
import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;

@FeignClient(name = "NEXUS-DOCKER-REPOSITORY-PUBLIC-CLIENT", url = "${api.nexus.public}/repositories/docker", configuration = {NexusApiFeignClientConfiguration.class})
public interface DockerRepositoryFeignClient {
    // Docker - Group
    @GetMapping("group/{repositoryName}")
    public ResponseEntity<DockerGroupDto.Response> getDockerGroupRepository(@PathVariable("repositoryName") String name);

    @PostMapping("group")
    public ResponseEntity<Void> createDockerGroupRepository(@RequestBody DockerGroupDto.Request data);

    @PutMapping("group/{repositoryName}")
    public ResponseEntity<Void> updateDockerGroupRepository(@PathVariable("repositoryName") String name, @RequestBody DockerGroupDto.Request data);

    // Docker - Hosted
    @GetMapping("hosted/{repositoryName}")
    public ResponseEntity<DockerHostedDto.Response> getDockerHostedRepository(@PathVariable("repositoryName") String name);

    @PostMapping("hosted")
    public ResponseEntity<Void> createDockerHostedRepository(@RequestBody DockerHostedDto.Request data);

    @PutMapping("hosted/{repositoryName}")
    public ResponseEntity<Void> updateDockerHostedRepository(@PathVariable("repositoryName") String name, @RequestBody DockerHostedDto.Request data);

    // Docker - Proxy
    @GetMapping("proxy/{repositoryName}")
    public ResponseEntity<DockerProxyDto.Response> getDockerProxyRepository(@PathVariable("repositoryName") String name);

    @PostMapping("proxy")
    public ResponseEntity<Void> createDockerProxyRepository(@RequestBody DockerProxyDto.Request data);

    @PutMapping("proxy/{repositoryName}")
    public ResponseEntity<Void> updateDockerProxyRepository(@PathVariable("repositoryName") String name, @RequestBody DockerProxyDto.Request data);
}

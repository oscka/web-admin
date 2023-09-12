package com.osckorea.openmsa.admin.repository.docker.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.repository.docker.dto.DockerGroupDto;
import com.osckorea.openmsa.admin.repository.docker.dto.DockerHostedDto;
import com.osckorea.openmsa.admin.repository.docker.dto.DockerProxyDto;
import com.osckorea.openmsa.admin.repository.docker.feign.DockerRepositoryFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DockerRepositoryService {
    private final DockerRepositoryFeignClient dockerRepositoryFeignClient;

    // Find
    public DockerGroupDto.Response getDockerGroupRepository(String name) {
        ResponseEntity<DockerGroupDto.Response> response = this.dockerRepositoryFeignClient.getDockerGroupRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public DockerHostedDto.Response getDockerHostedRepository(String name) {
        ResponseEntity<DockerHostedDto.Response> response = this.dockerRepositoryFeignClient.getDockerHostedRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public DockerProxyDto.Response getDockerProxyRepository(String name) {
        ResponseEntity<DockerProxyDto.Response> response = this.dockerRepositoryFeignClient.getDockerProxyRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    // Create
    public Integer createDockerGroupRepository(DockerGroupDto.Request data) {
        return this.dockerRepositoryFeignClient.createDockerGroupRepository(data).getStatusCodeValue();
    }

    public Integer createDockerHostedRepository(DockerHostedDto.Request data) {
        return this.dockerRepositoryFeignClient.createDockerHostedRepository(data).getStatusCodeValue();
    }

    public Integer createDockerProxyRepository(DockerProxyDto.Request data) {
        return this.dockerRepositoryFeignClient.createDockerProxyRepository(data).getStatusCodeValue();
    }

    // Update
    public Integer updateDockerGroupRepository(String name, DockerGroupDto.Request data) {
        return this.dockerRepositoryFeignClient.updateDockerGroupRepository(name, data).getStatusCodeValue();
    }

    public Integer updateDockerHostedRepository(String name, DockerHostedDto.Request data) {
        return this.dockerRepositoryFeignClient.updateDockerHostedRepository(name, data).getStatusCodeValue();
    }

    public Integer updateDockerProxyRepository(String name, DockerProxyDto.Request data) {
        return this.dockerRepositoryFeignClient.updateDockerProxyRepository(name, data).getStatusCodeValue();
    }
}

package com.osckorea.openmsa.admin.repository.maven.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osckorea.openmsa.admin.repository.maven.dto.MavenGroupDto;
import com.osckorea.openmsa.admin.repository.maven.dto.MavenHostedDto;
import com.osckorea.openmsa.admin.repository.maven.dto.MavenProxyDto;
import com.osckorea.openmsa.admin.repository.maven.feign.MavenRepositoryFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MavenRepositoryService {
    private final MavenRepositoryFeignClient mavenRepositoryFeignClient;

    // Find
    public MavenGroupDto.Response getMavenGroupRepository(String name) {
        ResponseEntity<MavenGroupDto.Response> response = this.mavenRepositoryFeignClient.getMavenGroupRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public MavenHostedDto.Response getMavenHostedRepository(String name) {
        ResponseEntity<MavenHostedDto.Response> response = this.mavenRepositoryFeignClient.getMavenHostedRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public MavenProxyDto.Response getMavenProxyRepository(String name) {
        ResponseEntity<MavenProxyDto.Response> response = this.mavenRepositoryFeignClient.getMavenProxyRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    // Create
    public Integer createMavenGroupRepository(MavenGroupDto.Request data) {
        return this.mavenRepositoryFeignClient.createMavenGroupRepository(data).getStatusCodeValue();
    }

    public Integer createMavenHostedRepository(MavenHostedDto.Request data) {
        return this.mavenRepositoryFeignClient.createMavenHostedRepository(data).getStatusCodeValue();
    }

    public Integer createMavenProxyRepository(MavenProxyDto.Request data) {
        return this.mavenRepositoryFeignClient.createMavenProxyRepository(data).getStatusCodeValue();
    }

    // Update
    public Integer updateMavenGroupRepository(String name, MavenGroupDto.Request data) {
        return this.mavenRepositoryFeignClient.updateMavenGroupRepository(name, data).getStatusCodeValue();
    }

    public Integer updateMavenHostedRepository(String name, MavenHostedDto.Request data) {
        return this.mavenRepositoryFeignClient.updateMavenHostedRepository(name, data).getStatusCodeValue();
    }

    public Integer updateMavenProxyRepository(String name, MavenProxyDto.Request data) {
        return this.mavenRepositoryFeignClient.updateMavenProxyRepository(name, data).getStatusCodeValue();
    }
}

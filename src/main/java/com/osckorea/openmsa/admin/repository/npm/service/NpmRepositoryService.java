package com.osckorea.openmsa.admin.repository.npm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osckorea.openmsa.admin.repository.npm.dto.NpmGroupDto;
import com.osckorea.openmsa.admin.repository.npm.dto.NpmHostedDto;
import com.osckorea.openmsa.admin.repository.npm.dto.NpmProxyDto;
import com.osckorea.openmsa.admin.repository.npm.feign.NpmRepositoryFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NpmRepositoryService {
    private final NpmRepositoryFeignClient npmRepositoryFeignClient;

    // Find
    public NpmGroupDto.Response getNpmGroupRepository(String name) {
        ResponseEntity<NpmGroupDto.Response> response = this.npmRepositoryFeignClient.getNpmGroupRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public NpmHostedDto.Response getNpmHostedRepository(String name) {
        ResponseEntity<NpmHostedDto.Response> response = this.npmRepositoryFeignClient.getNpmHostedRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public NpmProxyDto.Response getNpmProxyRepository(String name) {
        ResponseEntity<NpmProxyDto.Response> response = this.npmRepositoryFeignClient.getNpmProxyRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    // Create
    public Integer createNpmGroupRepository(NpmGroupDto.Request data) {
        return this.npmRepositoryFeignClient.createNpmGroupRepository(data).getStatusCodeValue();
    }

    public Integer createNpmHostedRepository(NpmHostedDto.Request data) {
        return this.npmRepositoryFeignClient.createNpmHostedRepository(data).getStatusCodeValue();
    }

    public Integer createNpmProxyRepository(NpmProxyDto.Request data) {
        return this.npmRepositoryFeignClient.createNpmProxyRepository(data).getStatusCodeValue();
    }

    // Update
    public Integer updateNpmGroupRepository(String name, NpmGroupDto.Request data) {
        return this.npmRepositoryFeignClient.updateNpmGroupRepository(name, data).getStatusCodeValue();
    }

    public Integer updateNpmHostedRepository(String name, NpmHostedDto.Request data) {
        return this.npmRepositoryFeignClient.updateNpmHostedRepository(name, data).getStatusCodeValue();
    }

    public Integer updateNpmProxyRepository(String name, NpmProxyDto.Request data) {
        return this.npmRepositoryFeignClient.updateNpmProxyRepository(name, data).getStatusCodeValue();
    }
}

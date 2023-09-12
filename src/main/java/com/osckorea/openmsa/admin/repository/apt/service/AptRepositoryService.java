package com.osckorea.openmsa.admin.repository.apt.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osckorea.openmsa.admin.repository.apt.dto.AptGroupDto;
import com.osckorea.openmsa.admin.repository.apt.dto.AptHostedDto;
import com.osckorea.openmsa.admin.repository.apt.dto.AptProxyDto;
import com.osckorea.openmsa.admin.repository.apt.feign.AptRepositoryFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AptRepositoryService {
    private final AptRepositoryFeignClient aptRepositoryFeignClient;

    // Find
    public AptGroupDto.Response getAptGroupRepository(String name) {
        ResponseEntity<AptGroupDto.Response> response = this.aptRepositoryFeignClient.getAptGroupRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public AptHostedDto.Response getAptHostedRepository(String name) {
        ResponseEntity<AptHostedDto.Response> response = this.aptRepositoryFeignClient.getAptHostedRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public AptProxyDto.Response getAptProxyRepository(String name) {
        ResponseEntity<AptProxyDto.Response> response = this.aptRepositoryFeignClient.getAptProxyRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    // Create
    public Integer createAptGroupRepository(AptGroupDto.Request data) {
        return this.aptRepositoryFeignClient.createAptGroupRepository(data).getStatusCodeValue();
    }

    public Integer createAptHostedRepository(AptHostedDto.Request data) {
        return this.aptRepositoryFeignClient.createAptHostedRepository(data).getStatusCodeValue();
    }

    public Integer createAptProxyRepository(AptProxyDto.Request data) {
        return this.aptRepositoryFeignClient.createAptProxyRepository(data).getStatusCodeValue();
    }

    // Update
    public Integer updateAptGroupRepository(String name, AptGroupDto.Request data) {
        return this.aptRepositoryFeignClient.updateAptGroupRepository(name, data).getStatusCodeValue();
    }

    public Integer updateAptHostedRepository(String name, AptHostedDto.Request data) {
        return this.aptRepositoryFeignClient.updateAptHostedRepository(name, data).getStatusCodeValue();
    }

    public Integer updateAptProxyRepository(String name, AptProxyDto.Request data) {
        return this.aptRepositoryFeignClient.updateAptProxyRepository(name, data).getStatusCodeValue();
    }
}

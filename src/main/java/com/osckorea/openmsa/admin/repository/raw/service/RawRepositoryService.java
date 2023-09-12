package com.osckorea.openmsa.admin.repository.raw.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osckorea.openmsa.admin.repository.raw.feign.RawRepositoryFeignClient;
import com.osckorea.openmsa.admin.repository.raw.dto.RawGroupDto;
import com.osckorea.openmsa.admin.repository.raw.dto.RawHostedDto;
import com.osckorea.openmsa.admin.repository.raw.dto.RawProxyDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RawRepositoryService {
    private final RawRepositoryFeignClient rawRepositoryFeignClient;

    // Find
    public RawGroupDto.Response getRawGroupRepository(String name) {
        ResponseEntity<RawGroupDto.Response> response = this.rawRepositoryFeignClient.getRawGroupRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public RawHostedDto.Response getRawHostedRepository(String name) {
        ResponseEntity<RawHostedDto.Response> response = this.rawRepositoryFeignClient.getRawHostedRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public RawProxyDto.Response getRawProxyRepository(String name) {
        ResponseEntity<RawProxyDto.Response> response = this.rawRepositoryFeignClient.getRawProxyRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    // Create
    public Integer createRawGroupRepository(RawGroupDto.Request data) {
        return this.rawRepositoryFeignClient.createRawGroupRepository(data).getStatusCodeValue();
    }

    public Integer createRawHostedRepository(RawHostedDto.Request data) {
        return this.rawRepositoryFeignClient.createRawHostedRepository(data).getStatusCodeValue();
    }

    public Integer createRawProxyRepository(RawProxyDto.Request data) {
        return this.rawRepositoryFeignClient.createRawProxyRepository(data).getStatusCodeValue();
    }

    // Update
    public Integer updateRawGroupRepository(String name, RawGroupDto.Request data) {
        return this.rawRepositoryFeignClient.updateRawGroupRepository(name, data).getStatusCodeValue();
    }

    public Integer updateRawHostedRepository(String name, RawHostedDto.Request data) {
        return this.rawRepositoryFeignClient.updateRawHostedRepository(name, data).getStatusCodeValue();
    }

    public Integer updateRawProxyRepository(String name, RawProxyDto.Request data) {
        return this.rawRepositoryFeignClient.updateRawProxyRepository(name, data).getStatusCodeValue();
    }
}

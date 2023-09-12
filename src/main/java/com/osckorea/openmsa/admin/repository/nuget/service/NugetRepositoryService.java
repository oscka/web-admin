package com.osckorea.openmsa.admin.repository.nuget.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.repository.nuget.dto.NugetGroupDto;
import com.osckorea.openmsa.admin.repository.nuget.dto.NugetHostedDto;
import com.osckorea.openmsa.admin.repository.nuget.dto.NugetProxyDto;
import com.osckorea.openmsa.admin.repository.nuget.feign.NugetRepositoryFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NugetRepositoryService {
    private final NugetRepositoryFeignClient nugetRepositoryFeignClient;

    // Find
    public NugetGroupDto.Response getNugetGroupRepository(String name) {
        ResponseEntity<NugetGroupDto.Response> response = this.nugetRepositoryFeignClient.getNugetGroupRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public NugetHostedDto.Response getNugetHostedRepository(String name) {
        ResponseEntity<NugetHostedDto.Response> response = this.nugetRepositoryFeignClient.getNugetHostedRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public NugetProxyDto.Response getNugetProxyRepository(String name) {
        ResponseEntity<NugetProxyDto.Response> response = this.nugetRepositoryFeignClient.getNugetProxyRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    // Create
    public Integer createNugetGroupRepository(NugetGroupDto.Request data) {
        return this.nugetRepositoryFeignClient.createNugetGroupRepository(data).getStatusCodeValue();
    }

    public Integer createNugetHostedRepository(NugetHostedDto.Request data) {
        return this.nugetRepositoryFeignClient.createNugetHostedRepository(data).getStatusCodeValue();
    }

    public Integer createNugetProxyRepository(NugetProxyDto.Request data) {
        return this.nugetRepositoryFeignClient.createNugetProxyRepository(data).getStatusCodeValue();
    }

    // Update
    public Integer updateNugetGroupRepository(String name, NugetGroupDto.Request data) {
        return this.nugetRepositoryFeignClient.updateNugetGroupRepository(name, data).getStatusCodeValue();
    }

    public Integer updateNugetHostedRepository(String name, NugetHostedDto.Request data) {
        return this.nugetRepositoryFeignClient.updateNugetHostedRepository(name, data).getStatusCodeValue();
    }

    public Integer updateNugetProxyRepository(String name, NugetProxyDto.Request data) {
        return this.nugetRepositoryFeignClient.updateNugetProxyRepository(name, data).getStatusCodeValue();
    }
}

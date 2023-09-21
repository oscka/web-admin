package com.osckorea.openmsa.nexus.repository.pypi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osckorea.openmsa.nexus.repository.pypi.dto.PypiGroupDto;
import com.osckorea.openmsa.nexus.repository.pypi.dto.PypiHostedDto;
import com.osckorea.openmsa.nexus.repository.pypi.dto.PypiProxyDto;
import com.osckorea.openmsa.nexus.repository.pypi.feign.PypiRepositoryFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PypiRepositoryService {
    private final PypiRepositoryFeignClient pypiRepositoryFeignClient;

    // Find
    public PypiGroupDto.Response getPypiGroupRepository(String name) {
        ResponseEntity<PypiGroupDto.Response> response = this.pypiRepositoryFeignClient.getPypiGroupRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public PypiHostedDto.Response getPypiHostedRepository(String name) {
        ResponseEntity<PypiHostedDto.Response> response = this.pypiRepositoryFeignClient.getPypiHostedRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    public PypiProxyDto.Response getPypiProxyRepository(String name) {
        ResponseEntity<PypiProxyDto.Response> response = this.pypiRepositoryFeignClient.getPypiProxyRepository(name);

        if(response.getStatusCodeValue() == 200) {
            return response.getBody();
        }

        return null;
    }

    // Create
    public Integer createPypiGroupRepository(PypiGroupDto.Request data) {
        return this.pypiRepositoryFeignClient.createPypiGroupRepository(data).getStatusCodeValue();
    }

    public Integer createPypiHostedRepository(PypiHostedDto.Request data) {
        return this.pypiRepositoryFeignClient.createPypiHostedRepository(data).getStatusCodeValue();
    }

    public Integer createPypiProxyRepository(PypiProxyDto.Request data) {
        return this.pypiRepositoryFeignClient.createPypiProxyRepository(data).getStatusCodeValue();
    }

    // Update
    public Integer updatePypiGroupRepository(String name, PypiGroupDto.Request data) {
        return this.pypiRepositoryFeignClient.updatePypiGroupRepository(name, data).getStatusCodeValue();
    }

    public Integer updatePypiHostedRepository(String name, PypiHostedDto.Request data) {
        return this.pypiRepositoryFeignClient.updatePypiHostedRepository(name, data).getStatusCodeValue();
    }

    public Integer updatePypiProxyRepository(String name, PypiProxyDto.Request data) {
        return this.pypiRepositoryFeignClient.updatePypiProxyRepository(name, data).getStatusCodeValue();
    }
}

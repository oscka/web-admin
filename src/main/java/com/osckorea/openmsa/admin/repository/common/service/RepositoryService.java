package com.osckorea.openmsa.admin.repository.common.service;

import org.springframework.stereotype.Service;

import com.osckorea.openmsa.admin.repository.common.feign.RepositoryPublicFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RepositoryService {
    private final RepositoryPublicFeignClient repositoryFeignClient;

    public Integer deleteRepository(String name) {
        return this.repositoryFeignClient.deleteRepository(name).getStatusCodeValue();
    }
}

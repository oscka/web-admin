package com.osckorea.openmsa.admin.browse.service;

import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.nexus.feign.repository.NexusRepositoryInternalUiFeginClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrowseInternalService {
    private final NexusRepositoryInternalUiFeginClient nexusRepositoryInternalUiFeginClient;

    public Object getRepositoryInfo(String name) {
        return this.nexusRepositoryInternalUiFeginClient.getRepositoryInfo(name);
    }
}

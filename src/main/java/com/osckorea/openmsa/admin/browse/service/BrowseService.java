package com.osckorea.openmsa.admin.browse.service;

import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.browse.dto.RepositoryDto;
import com.osckorea.openmsa.admin.browse.dto.BrowseTreeDto.Request;
import com.osckorea.openmsa.admin.browse.dto.BrowseTreeDto.Response;
import com.osckorea.openmsa.admin.nexus.dto.external.ExternalApiRequestDto;
import com.osckorea.openmsa.admin.nexus.dto.external.ExternalApiResponseDto;
import com.osckorea.openmsa.admin.nexus.feign.NexusExternalFeignClient;
import com.osckorea.openmsa.admin.nexus.feign.NexusInternalUiFeginClient;
import com.osckorea.openmsa.admin.nexus.feign.NexusPublicRepositoryFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrowseService {
    private final NexusExternalFeignClient nexusExternalFeignClient;
    private final NexusInternalUiFeginClient nexusInternalUiFeginClient;
    private final NexusPublicRepositoryFeignClient nexusFeginClient;

    public RepositoryDto.ResponseDetail[] getResponseDetails() {
        return this.nexusInternalUiFeginClient.getRepositoriesDetail();
    };

    public Object[] getRepositorySettings() {
        return this.nexusFeginClient.getRepositorySettings();
    }

    public ExternalApiResponseDto<Response> getData(ExternalApiRequestDto<Request> data) {
        return (ExternalApiResponseDto<Response>) this.nexusExternalFeignClient.requestExternal(data);
    }
}

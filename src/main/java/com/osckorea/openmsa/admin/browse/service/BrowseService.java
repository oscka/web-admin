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
    private final NexusPublicRepositoryFeignClient nexusPublicRepositoryFeignClient;

    public RepositoryDto.Response[] getRepositories() {
        return this.nexusInternalUiFeginClient.getRepositories();
    }

    public RepositoryDto.ResponseDetail[] getRepositoriesDetail() {
        return this.nexusInternalUiFeginClient.getRepositoriesDetail();
    };

    public Object[] getRepositorySettings() {
        return this.nexusPublicRepositoryFeignClient.getRepositorySettings();
    }

    public ExternalApiResponseDto<Response> getBrowseTreeData(String repositoryName, String nodeId) {
        Request data = Request.builder().repositoryName(repositoryName).node(nodeId).build();

        ExternalApiRequestDto<Request> requestData= ExternalApiRequestDto.<Request>builder()
                                                                            .action("coreui_Browse")
                                                                            .method("read")
                                                                            .data(new Request[] {data})
                                                                            .type("rpc")
                                                                            .tid(1)
                                                                            .build();


        return (ExternalApiResponseDto<Response>) this.nexusExternalFeignClient.request(requestData);
    }
}

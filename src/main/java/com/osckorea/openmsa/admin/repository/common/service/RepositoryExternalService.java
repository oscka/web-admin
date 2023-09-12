package com.osckorea.openmsa.admin.repository.common.service;

import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.nexus.dto.ExternalApiRequestDto;
import com.osckorea.openmsa.admin.nexus.dto.ExternalApiResponseDto;
import com.osckorea.openmsa.admin.nexus.feign.NexusExternalFeignClient;
import com.osckorea.openmsa.admin.repository.common.dto.RepositoryDto;
import com.osckorea.openmsa.global.util.JsonUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RepositoryExternalService {
    private final NexusExternalFeignClient nexusExternalFeignClient;

    public RepositoryDto.Response[] getRepositoryReferences() {
        RepositoryDto.Request data = RepositoryDto.Request.builder().build();

        ExternalApiRequestDto<RepositoryDto.Request> requestData = ExternalApiRequestDto.<RepositoryDto.Request>builder()
                                                                                        .action("coreui_Repository")
                                                                                        .method("readReferences")
                                                                                        .data(new RepositoryDto.Request[] {data})
                                                                                        .build();

        ExternalApiResponseDto<RepositoryDto.Response> responseData = (ExternalApiResponseDto<RepositoryDto.Response>) this.nexusExternalFeignClient.request(requestData);

        if(responseData.getResult().getSuccess() == true) {
            return JsonUtil.convertValue(responseData.getResult().getData(), RepositoryDto.Response[].class);
        }

        return null;
    }

    public RepositoryDto.Response[] getRepositoryReferences(RepositoryDto.Request.Filter filter) {
        RepositoryDto.Request data = RepositoryDto.Request.builder()
                                                            .filter(new RepositoryDto.Request.Filter[] {filter})
                                                            .build();

        ExternalApiRequestDto<RepositoryDto.Request> requestData = ExternalApiRequestDto.<RepositoryDto.Request>builder()
                                                                                                    .action("coreui_Repository")
                                                                                                    .method("readReferences")
                                                                                                    .data(new RepositoryDto.Request[] {data})
                                                                                                    .build();

        ExternalApiResponseDto<RepositoryDto.Response> responseData = (ExternalApiResponseDto<RepositoryDto.Response>) this.nexusExternalFeignClient.request(requestData);

        if(responseData.getResult().getSuccess() == true) {
            return JsonUtil.convertValue(responseData.getResult().getData(), RepositoryDto.Response[].class);
        }

        return null;
    }
}

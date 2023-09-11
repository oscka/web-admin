package com.osckorea.openmsa.admin.browse.service;

import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.browse.dto.BrowseRepositoryDto;
import com.osckorea.openmsa.admin.browse.dto.BrowseTreeNodeDto;
import com.osckorea.openmsa.admin.browse.dto.BrowseRepositoryDto.Request.Filter;
import com.osckorea.openmsa.admin.nexus.dto.external.ExternalApiRequestDto;
import com.osckorea.openmsa.admin.nexus.dto.external.ExternalApiResponseDto;
import com.osckorea.openmsa.admin.nexus.feign.NexusExternalFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrowseExternalService {
    private final NexusExternalFeignClient nexusExternalFeignClient;

    /**
     * @return 현재 모든 저장소 기본 정보
     */
    public Object getRepositoryReferences() {
        BrowseRepositoryDto.Request data = BrowseRepositoryDto.Request.builder().build();
        ExternalApiRequestDto<BrowseRepositoryDto.Request> requestData = ExternalApiRequestDto.<BrowseRepositoryDto.Request>builder()
                                                                                                .action("coreui_Repository")
                                                                                                .method("readReferences")
                                                                                                .data(new BrowseRepositoryDto.Request[] {data})
                                                                                                .build();

        ExternalApiResponseDto<BrowseRepositoryDto.Response> responseData = (ExternalApiResponseDto<BrowseRepositoryDto.Response>) this.nexusExternalFeignClient.request(requestData);

        if(responseData.getResult().getSuccess() == true) {
            return responseData.getResult().getData();
        }

        return null;
    }

    /**
     * @param filter : 필터링 하고자하는 대상의 정보
     * 
     * @return 필터링 된 모든 저장소 기본 정보
     */
    public Object getRepositoryReferences(Filter filter) {
        Filter filterData = Filter.builder().property(filter.getProperty()).value(filter.getValue()).build();
        BrowseRepositoryDto.Request data = BrowseRepositoryDto.Request.builder().filter(new Filter[] {filterData}).build();
        ExternalApiRequestDto<BrowseRepositoryDto.Request> requestData = ExternalApiRequestDto.<BrowseRepositoryDto.Request>builder()
                                                                                                .action("coreui_Repository")
                                                                                                .method("readReferences")
                                                                                                .data(new BrowseRepositoryDto.Request[] {data})
                                                                                                .build();

        ExternalApiResponseDto<BrowseRepositoryDto.Response> responseData = (ExternalApiResponseDto<BrowseRepositoryDto.Response>) this.nexusExternalFeignClient.request(requestData);

        if(responseData.getResult().getSuccess() == true) {
            return responseData.getResult().getData();
        }

        return null;
    }

    /**
     * 
     * @param repositoryName : 저장소 이름, 예시) maven-central
     * 
     * @return 현재 노드에서의 하위 노드 목록
     */
    public Object getBrowseTreeNodes(String repositoryName) {
        BrowseTreeNodeDto.Request data = BrowseTreeNodeDto.Request.builder().repositoryName(repositoryName).node("/").build();

        ExternalApiRequestDto<BrowseTreeNodeDto.Request> requestData = ExternalApiRequestDto.<BrowseTreeNodeDto.Request>builder()
                                                                                            .action("coreui_Browse")
                                                                                            .method("read")
                                                                                            .data(new BrowseTreeNodeDto.Request[] {data})
                                                                                            .build();

        ExternalApiResponseDto<BrowseTreeNodeDto.Response> responseData = (ExternalApiResponseDto<BrowseTreeNodeDto.Response>) this.nexusExternalFeignClient.request(requestData);

        if(responseData.getResult().getSuccess() == true) {
            return responseData.getResult().getData();
        }

        return null;
    }

    /**
     * 
     * @param repositoryName : 저장소 이름, 예시) maven-central
     * @param nodeId : 현재 노드 Id, 예시1) / , 예시2) org/apache/logging
     * 
     * @return 현재 노드에서의 하위 노드 목록
     */
    public Object getBrowseTreeNodes(String repositoryName, String nodeId) {
        BrowseTreeNodeDto.Request data = BrowseTreeNodeDto.Request.builder().repositoryName(repositoryName).node(nodeId).build();

        ExternalApiRequestDto<BrowseTreeNodeDto.Request> requestData = ExternalApiRequestDto.<BrowseTreeNodeDto.Request>builder()
                                                                                            .action("coreui_Browse")
                                                                                            .method("read")
                                                                                            .data(new BrowseTreeNodeDto.Request[] {data})
                                                                                            .build();

        ExternalApiResponseDto<BrowseTreeNodeDto.Response> responseData = (ExternalApiResponseDto<BrowseTreeNodeDto.Response>) this.nexusExternalFeignClient.request(requestData);

        if(responseData.getResult().getSuccess() == true) {
            return responseData.getResult().getData();
        }

        return null;
    }
}

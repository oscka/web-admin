package com.osckorea.openmsa.nexus.browse.service;

import org.springframework.stereotype.Service;
import com.osckorea.openmsa.nexus.browse.dto.BrowseTreeNodeDto;
import com.osckorea.openmsa.nexus.common.dto.ExternalApiRequestDto;
import com.osckorea.openmsa.nexus.common.dto.ExternalApiResponseDto;
import com.osckorea.openmsa.nexus.common.feign.NexusExternalFeignClient;
import com.osckorea.openmsa.global.util.JsonUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrowseExternalService {
    private final NexusExternalFeignClient nexusExternalFeignClient;

    /**
     * 
     * @param repositoryName : 대상 저장소 명
     * @param nodeId : 대상 노드의 Id 경로
     * 
     * @return 하위 노드들의 목록
     */
    public BrowseTreeNodeDto.Response[] getBrowseTreeNodes(String repositoryName, String nodeId) {
        BrowseTreeNodeDto.Request data = BrowseTreeNodeDto.Request.builder()
                                                                    .repositoryName(repositoryName)
                                                                    .node(nodeId)
                                                                    .build();

        ExternalApiRequestDto<BrowseTreeNodeDto.Request> requestData = ExternalApiRequestDto.<BrowseTreeNodeDto.Request>builder()
                                                                                            .action("coreui_Browse")
                                                                                            .method("read")
                                                                                            .data(new BrowseTreeNodeDto.Request[] {data})
                                                                                            .build();

        ExternalApiResponseDto<BrowseTreeNodeDto.Response> responseData = (ExternalApiResponseDto<BrowseTreeNodeDto.Response>) this.nexusExternalFeignClient.request(requestData);

        if(responseData.getResult().getSuccess() == true) {
            return JsonUtil.convertValue(responseData.getResult().getData(), BrowseTreeNodeDto.Response[].class);
        }

        return null;
    }
}

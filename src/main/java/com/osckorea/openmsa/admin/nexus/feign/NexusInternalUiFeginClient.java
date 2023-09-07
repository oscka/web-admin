package com.osckorea.openmsa.admin.nexus.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.osckorea.openmsa.admin.browse.dto.RepositoryDto.Response;
import com.osckorea.openmsa.admin.browse.dto.RepositoryDto.ResponseDetail;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;

@FeignClient(name = "NEXUS-INTERNAL-UI-CLIENT", url = "${api.nexus.internal}/ui", configuration = {NexusFeignClientConfiguration.class})
public interface NexusInternalUiFeginClient {
    @GetMapping("repositories")
    public Response[] getRepositories();

    @GetMapping("repositories/details")
    public ResponseDetail[] getRepositoriesDetail();
}

package com.osckorea.openmsa.nexus.repository.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.osckorea.openmsa.nexus.repository.common.dto.ListDetailDto;
import com.osckorea.openmsa.nexus.repository.common.dto.ListDto;
import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;

@FeignClient(name = "NEXUS-REPOSITORY-INTERNAL-UI-CLIENT", url = "${api.nexus.internal}/ui/repositories", configuration = {NexusApiFeignClientConfiguration.class})
public interface RepositoryInternalFeignClient {
    @GetMapping
    public ListDto[] getRepositories();

    @GetMapping("detail")
    public ListDetailDto[] getRepositoriesDetails();

    @GetMapping("repository/{repositoryName}")
    public Object getRepositoryInformation(@PathVariable("repositoryName") String name);
}

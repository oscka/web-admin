package com.osckorea.openmsa.admin.repository.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.repository.common.dto.ListDetailDto;
import com.osckorea.openmsa.admin.repository.common.dto.ListDto;

@FeignClient(name = "NEXUS-REPOSITORY-INTERNAL-UI-CLIENT", url = "${api.nexus.internal}/ui/repositories", configuration = {NexusFeignClientConfiguration.class})
public interface RepositoryInternalFeignClient {
    @GetMapping
    public ListDto[] getRepositories();

    @GetMapping("detail")
    public ListDetailDto[] getRepositoriesDetails();

    @GetMapping("repository/{repositoryName}")
    public Object getRepositoryInformation(@PathVariable("repositoryName") String name);
}

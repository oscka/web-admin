package com.osckorea.openmsa.admin.nexus.feign.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.nexus.dto.repository.ListDetailDto;
import com.osckorea.openmsa.admin.nexus.dto.repository.ListDto;

@FeignClient(name = "NEXUS-INTERNAL-UI-CLIENT", url = "${api.nexus.internal}/ui", configuration = {NexusFeignClientConfiguration.class})
public interface NexusRepositoryInternalUiFeginClient {
    @GetMapping("repositories")
    public ListDto[] getRepositories();

    @GetMapping("repositories/details")
    public ListDetailDto[] getRepositoriesDetail();

    @GetMapping("repositories/repository/{repositoryName}")
    public Object getRepositoryInfo(@PathVariable("repositoryName") String name);
}

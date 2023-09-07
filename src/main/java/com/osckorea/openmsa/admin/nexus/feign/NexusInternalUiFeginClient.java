// package com.osckorea.openmsa.admin.nexus.feign;

// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.web.bind.annotation.GetMapping;
// import com.osckorea.openmsa.admin.browse.dto.RepositoryDto;
// import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;

// @FeignClient(name = "NEXUS-INTERNAL-UI-CLIENT", url = "${api.nexus.internal}/ui", configuration = {NexusFeignClientConfiguration.class})
// public interface NexusInternalUiFeginClient {
//     @GetMapping("repositories")
//     public RepositoryDto.Response[] getRepositories();

//     @GetMapping("repositories/details")
//     public RepositoryDto.ResponseDetail[] getRepositoriesDetail();
// }

package com.osckorea.openmsa.admin.repository.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;

@FeignClient(name = "NEXUS-REPOSITORY-PUBLIC-CLIENT", url = "{api.nexus.public}", configuration = {NexusFeignClientConfiguration.class})
public interface RepositoryPublicFeignClient {
    /**
     * 저장소 format에 관계없이 해당하는 저장소를 삭제합니다.
     * @param name : 저장소 명
     * @return 
     */
    @DeleteMapping("/repositories/{repositoryName}")
    public ResponseEntity<Void> deleteRepository(@PathVariable("repositoryName") String name);
}

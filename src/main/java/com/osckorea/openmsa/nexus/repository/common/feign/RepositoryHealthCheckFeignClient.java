package com.osckorea.openmsa.nexus.repository.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;

@FeignClient(name = "NEXUS-REPOSITORY-HEALTHCHECK-CLIENT", url = "${api.nexus.base-url}/service/rest/healthcheck", configuration = {NexusApiFeignClientConfiguration.class})
public interface RepositoryHealthCheckFeignClient {
    @GetMapping("healthCheckSummary/{repositoryName}/current/summary.html")
    public String getRepositoryHealthCheckSummaryHtml(@PathVariable("repositoryName") String name);

    @GetMapping("healthCheckDetail/{repositoryName}/current/details.html")
    public String getRepositoryHealthCheckDetailHtml(@PathVariable("repositoryName") String name);
}

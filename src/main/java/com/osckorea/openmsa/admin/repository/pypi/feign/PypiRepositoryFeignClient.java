package com.osckorea.openmsa.admin.repository.pypi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.osckorea.openmsa.admin.nexus.config.NexusFeignClientConfiguration;
import com.osckorea.openmsa.admin.repository.pypi.dto.PypiGroupDto;
import com.osckorea.openmsa.admin.repository.pypi.dto.PypiHostedDto;
import com.osckorea.openmsa.admin.repository.pypi.dto.PypiProxyDto;

@FeignClient(name = "NEXUS-PYPI-REPOSITORY-PUBLIC-CLIENT", url = "${api.nexus.public}/repositories/pypi", configuration = {NexusFeignClientConfiguration.class})
public interface PypiRepositoryFeignClient {
    // Pypi - Group
    @GetMapping("group/{repositoryName}")
    public ResponseEntity<PypiGroupDto.Response> getPypiGroupRepository(@PathVariable("repositoryName") String name);

    @PostMapping("group")
    public ResponseEntity<Void> createPypiGroupRepository(@RequestBody PypiGroupDto.Request data);

    @PutMapping("group/{repositoryName}")
    public ResponseEntity<Void> updatePypiGroupRepository(@PathVariable("repositoryName") String name, @RequestBody PypiGroupDto.Request data);

    // Pypi - Hosted
    @GetMapping("hosted/{repositoryName}")
    public ResponseEntity<PypiHostedDto.Response> getPypiHostedRepository(@PathVariable("repositoryName") String name);

    @PostMapping("hosted")
    public ResponseEntity<Void> createPypiHostedRepository(@RequestBody PypiHostedDto.Request data);

    @PutMapping("hosted/{repositoryName}")
    public ResponseEntity<Void> updatePypiHostedRepository(@PathVariable("repositoryName") String name, @RequestBody PypiHostedDto.Request data);

    // Pypi - Proxy
    @GetMapping("proxy/{repositoryName}")
    public ResponseEntity<PypiProxyDto.Response> getPypiProxyRepository(@PathVariable("repositoryName") String name);

    @PostMapping("proxy")
    public ResponseEntity<Void> createPypiProxyRepository(@RequestBody PypiProxyDto.Request data);

    @PutMapping("proxy/{repositoryName}")
    public ResponseEntity<Void> updatePypiProxyRepository(@PathVariable("repositoryName") String name, @RequestBody PypiProxyDto.Request data);
}

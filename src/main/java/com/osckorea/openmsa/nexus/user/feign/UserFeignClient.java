package com.osckorea.openmsa.nexus.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.osckorea.openmsa.nexus.common.config.NexusApiFeignClientConfiguration;
import com.osckorea.openmsa.nexus.user.domain.NexusUser;


@FeignClient(value = "userFeignClient", url = "${api.nexus.internal}", configuration = {NexusApiFeignClientConfiguration.class})
public interface UserFeignClient {

    @GetMapping("/ui/user")
    NexusUser getUserInfo();
}

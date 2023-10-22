package com.osckorea.openmsa.nexus.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osckorea.openmsa.nexus.user.domain.NexusUser;
import com.osckorea.openmsa.nexus.user.feign.UserFeignClient;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class NexusUserService {
    
    private final UserFeignClient userFeignClient;

    public void getUserInfo() {
        NexusUser user = userFeignClient.getUserInfo();

        log.warn(user.getUserId());
        log.warn(user.getFirstName());
        log.warn(user.getLastName());
        log.warn(user.getEmail());
        log.warn(user.getExternal());
    }
}

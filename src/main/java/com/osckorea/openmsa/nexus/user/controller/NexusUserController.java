package com.osckorea.openmsa.nexus.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osckorea.openmsa.nexus.user.service.NexusUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("/nexus/users")
@RequiredArgsConstructor
@RestController
@Slf4j
public class NexusUserController {
    private final NexusUserService userService;

    @GetMapping("")
    public void getUser() {
        userService.getUserInfo();
    }
}

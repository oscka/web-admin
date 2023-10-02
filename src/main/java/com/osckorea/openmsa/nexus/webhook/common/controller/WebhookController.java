package com.osckorea.openmsa.nexus.webhook.common.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Nexus Webhook CallBack API")
@Slf4j
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class WebhookController {
    @Operation(summary = "Nexus에서 발생하는 모든 Webhook을 받아 로그를 찍는 CallBack API 입니다.")
    @PostMapping("webhook")
    public void webhook(@RequestBody Object payload) {
        log.info(payload.toString());
    }
}

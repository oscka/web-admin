package com.osckorea.openmsa.nexus.webhook.repository.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.nexus.webhook.repository.dto.WebhookRepositoryAssetDto;
import com.osckorea.openmsa.nexus.webhook.repository.dto.WebhookRepositoryComponentDto;
import com.osckorea.openmsa.nexus.webhook.repository.dto.WebhookRepositoryDto;
import com.osckorea.openmsa.nexus.webhook.repository.service.WebhookRepositoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Nexus Repository CallBack API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class WebhookRepositoryController {
    private final WebhookRepositoryService webhookRepositoryService;

    @Operation(summary = "저장소 관련 이벤트에 대한 웹훅 CallBack API 입니다.")
    @PostMapping("webhook/repository")
    public void repositoryWebhook(@RequestBody WebhookRepositoryDto webhookPayload) {
        this.webhookRepositoryService.repositoryWebhook(webhookPayload);
    }

    @Operation(summary = "Asset 관련 이벤트에 대한 웹훅 CallBack API 입니다.")
    @PostMapping("webhook/repository/asset")
    public void repositoryAssetWebhook(@RequestBody WebhookRepositoryAssetDto webhookPayload) {
        this.webhookRepositoryService.repositoryAssetWebhook(webhookPayload);
    }

    @Operation(summary = "Component 관련 이벤트에 대한 웹훅 CallBack API 입니다.")
    @PostMapping("webhook/repository/component")
    public void repositoryComponentWebhook(@RequestBody WebhookRepositoryComponentDto webhookPayload) {
        this.webhookRepositoryService.repositoryComponentWebhook(webhookPayload);
    }
}

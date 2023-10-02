package com.osckorea.openmsa.nexus.webhook.repository.service;

import org.springframework.stereotype.Service;
import com.osckorea.openmsa.nexus.webhook.repository.dto.WebhookRepositoryAssetDto;
import com.osckorea.openmsa.nexus.webhook.repository.dto.WebhookRepositoryComponentDto;
import com.osckorea.openmsa.nexus.webhook.repository.dto.WebhookRepositoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebhookRepositoryService {
    public void repositoryWebhook(WebhookRepositoryDto payload) {
        log.info(payload.toString());
    }

    public void repositoryAssetWebhook(WebhookRepositoryAssetDto payload) {
        log.info(payload.toString());
    }
    
    public void repositoryComponentWebhook(WebhookRepositoryComponentDto payload) {
        log.info(payload.toString());
    }
}

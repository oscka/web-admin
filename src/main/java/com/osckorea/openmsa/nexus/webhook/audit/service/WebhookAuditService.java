package com.osckorea.openmsa.nexus.webhook.audit.service;

import org.springframework.stereotype.Service;
import com.osckorea.openmsa.nexus.webhook.audit.dto.WebhookAuditDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebhookAuditService {
    public void auditWebhook(WebhookAuditDto payload) {
        log.info(payload.toString());
    }
}

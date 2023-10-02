package com.osckorea.openmsa.nexus.webhook.audit.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.nexus.webhook.audit.dto.WebhookAuditDto;
import com.osckorea.openmsa.nexus.webhook.audit.service.WebhookAuditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Nexus Audit Webhook CallBack API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class WebhookAuditController {
    private final WebhookAuditService webhookAuditService;

    @Operation(summary = "Audit 이벤트 관련 CallBack API 입니다.")
    @PostMapping("webhook/audit")
    public void auditWebhook(@RequestBody WebhookAuditDto webhookPayload) {
        this.webhookAuditService.auditWebhook(webhookPayload);
    }
}

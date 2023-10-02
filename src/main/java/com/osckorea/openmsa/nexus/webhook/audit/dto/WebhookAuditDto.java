package com.osckorea.openmsa.nexus.webhook.audit.dto;

import com.osckorea.openmsa.nexus.webhook.audit.dto.types.Audit;
import com.osckorea.openmsa.nexus.webhook.common.dto.AbstractWebhookDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class WebhookAuditDto extends AbstractWebhookDto {
    private Audit audit;
}

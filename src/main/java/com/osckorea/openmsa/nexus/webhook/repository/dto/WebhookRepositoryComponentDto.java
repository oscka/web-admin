package com.osckorea.openmsa.nexus.webhook.repository.dto;

import java.sql.Timestamp;
import com.osckorea.openmsa.nexus.repository.common.dto.types.Component;
import com.osckorea.openmsa.nexus.webhook.common.dto.AbstractWebhookDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class WebhookRepositoryComponentDto extends AbstractWebhookDto{
    @Schema(example = "2023-10-02T20:19:34.525+0000")
    private Timestamp timestamp;

    @Schema(example = "maven-central")
    private String repositoryName;

    @Schema(example = "CREATED")
    private String action;
    
    private Component component;
}

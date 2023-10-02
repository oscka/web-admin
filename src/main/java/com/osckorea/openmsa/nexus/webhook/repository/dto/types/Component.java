package com.osckorea.openmsa.nexus.webhook.repository.dto.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(name = "WebhookComponentType")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Component {
    @Schema(example = "08909bf0c86cf6c9600aade89e1c5e25")
    private String id;

    @Schema(example = "bnBtLXByb3h5OjA4OTA5YmYwYzg2Y2Y2Yzk2MDBhYWRlODllMWM1ZTI1")
    private String componentId;

    @Schema(example = "maven2")
    private String format;

    @Schema(example = "log4j-core")
    private String name;

    @Schema(example = "log4j")
    private String group;

    @Schema(example = "1.2.12")
    private String version;
}

package com.osckorea.openmsa.admin.nexus.dto.external;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExternalApiRequestDto<T> {
    private String action;
    
    private String method;

    private T[] data;

    @Builder.Default
    private String type = "rpc";

    @Builder.Default
    private Integer tid = 1;
}

package com.osckorea.openmsa.nexus.common.dto;

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

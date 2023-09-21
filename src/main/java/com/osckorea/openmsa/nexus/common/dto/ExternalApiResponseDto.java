package com.osckorea.openmsa.nexus.common.dto;

import lombok.Getter;

@Getter
public class ExternalApiResponseDto<T> {
    private String action;
    private String method;
    private Result result;
    private String type;
    private Integer tid;

    @Getter
    public class Result {
        private String message;
        private Boolean authenticationRequired;
        private Boolean success;
        private T[] data;
    }
}

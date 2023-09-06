package com.osckorea.openmsa.admin.nexus.dto.partial;

import lombok.Getter;

@Getter
public class Storage {
    private String blobStoreName;
    private Boolean strictContentTypeValidation;
    private String writePolicy;
}

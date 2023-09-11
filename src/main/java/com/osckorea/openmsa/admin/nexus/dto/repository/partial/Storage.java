package com.osckorea.openmsa.admin.nexus.dto.repository.partial;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Storage {
    private String blobStoreName;
    private Boolean strictContentTypeValidation;
    private String writePolicy;
}

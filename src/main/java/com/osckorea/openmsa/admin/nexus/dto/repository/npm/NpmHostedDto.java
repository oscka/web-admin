package com.osckorea.openmsa.admin.nexus.dto.repository.npm;

import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Cleanup;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Component;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Storage;

import lombok.Getter;

@Getter
public class NpmHostedDto {
    private String name;
    private String url;
    private String format;
    private String type;
    private Boolean online;
    
    private Storage storage;
    private Cleanup cleanup;
    private Component component;
}

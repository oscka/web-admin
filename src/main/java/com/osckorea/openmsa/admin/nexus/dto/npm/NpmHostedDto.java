package com.osckorea.openmsa.admin.nexus.dto.npm;

import com.osckorea.openmsa.admin.nexus.dto.partial.Cleanup;
import com.osckorea.openmsa.admin.nexus.dto.partial.Component;
import com.osckorea.openmsa.admin.nexus.dto.partial.Storage;

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

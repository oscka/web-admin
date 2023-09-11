package com.osckorea.openmsa.admin.nexus.dto.component.partial;

import lombok.Getter;

@Getter
public class Item {
    private String id;
    private String repository;
    private String format;
    private String group;
    private String name;
    private String version;

    @Getter
    public static class Asset {
        
    }
}

package com.osckorea.openmsa.admin.nexus.dto.repository;

import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Group;
import com.osckorea.openmsa.admin.nexus.dto.repository.partial.Storage;
import lombok.Getter;

public class GroupDto {
    @Getter
    public static class Request {
        private String name;
        private String online;
        private Storage storage;
        private Group group;
    }

    @Getter
    public static class Response {
        private String name;
        private String format;
        private String url;
        private Boolean online;
        private Storage storage;
        private Group group;
        private String type;
    }
}

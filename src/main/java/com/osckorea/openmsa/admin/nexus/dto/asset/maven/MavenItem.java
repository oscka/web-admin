package com.osckorea.openmsa.admin.nexus.dto.asset.maven;

import com.osckorea.openmsa.admin.nexus.dto.asset.partial.CheckSum;
import lombok.Getter;

@Getter
public class MavenItem {
    private String downloadUrl;
    private String path;
    private String id;
    private String repository;
    private String format;
    private CheckSum checksum;
    private String contentType;
    private String lastModified;
    private String lastDownloaded;
    private Integer fileSize;
    private String blobCreated;
    private Maven2 maven2;
}

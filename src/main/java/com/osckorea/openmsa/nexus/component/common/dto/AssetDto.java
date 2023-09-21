package com.osckorea.openmsa.nexus.component.common.dto;

import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AssetDto {
    private String downloadUrl;
    private String path;
    private String id;
    private String repository;
    private String format;
    private Checksum checksum;
    private String contentType;
    private Timestamp lastModified;
    private Timestamp lastDownloaded;
    private String uploader;
    private String uploaderIp;
    private Long fileSize;
    private Timestamp blobCreated;

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Checksum {
        private String sha1;
        private String sha512;
        private String sha256;
        private String md5;
    }
}

package com.osckorea.openmsa.nexus.search.common.dto;

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
    private String lastModified;
    private String lastDownloaded;
    private String uploader;
    private String uploaderIp;
    private Integer fileSize;
    private String blobCreated;

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Checksum {
        private String sha1;
        private String sha256;
        private String sha512;
        private String md5;
    }
}

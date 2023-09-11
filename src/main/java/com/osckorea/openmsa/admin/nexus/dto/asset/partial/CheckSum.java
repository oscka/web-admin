package com.osckorea.openmsa.admin.nexus.dto.asset.partial;

import lombok.Getter;

@Getter
public class CheckSum {
    private String sha1;
    private String sha512;
    private String sha256;
    private String md5;
}

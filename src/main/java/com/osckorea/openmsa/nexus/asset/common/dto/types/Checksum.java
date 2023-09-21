package com.osckorea.openmsa.nexus.asset.common.dto.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Checksum {
    private String sha1;
    private String sha512;
    private String sha256;
    private String md5;
}

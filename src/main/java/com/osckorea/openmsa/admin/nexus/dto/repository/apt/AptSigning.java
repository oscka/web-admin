package com.osckorea.openmsa.admin.nexus.dto.repository.apt;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AptSigning {
    private String keypair;
    private String passphrase;
}

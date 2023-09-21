package com.osckorea.openmsa.nexus.repository.apt.dto.types;

import lombok.Getter;

@Getter
public class AptSigning {
    private String keypair;
    private String passphrase;
}

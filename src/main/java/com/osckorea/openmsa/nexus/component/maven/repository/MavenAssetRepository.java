package com.osckorea.openmsa.nexus.component.maven.repository;

import org.springframework.data.repository.CrudRepository;
import com.osckorea.openmsa.nexus.component.maven.domain.MavenAsset;

public interface MavenAssetRepository extends CrudRepository<MavenAsset, String>{
    
}

package com.osckorea.openmsa.nexus.component.maven.repository;

import org.springframework.data.repository.CrudRepository;
import com.osckorea.openmsa.nexus.component.maven.domain.MavenComponent;

public interface MavenComponentRepository extends CrudRepository<MavenComponent, String>{
    
}

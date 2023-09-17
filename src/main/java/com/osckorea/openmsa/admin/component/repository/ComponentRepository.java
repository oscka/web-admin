package com.osckorea.openmsa.admin.component.repository;

import org.springframework.data.repository.CrudRepository;
import com.osckorea.openmsa.admin.component.domain.Component;

public interface ComponentRepository extends CrudRepository<Component, String>{
    
}

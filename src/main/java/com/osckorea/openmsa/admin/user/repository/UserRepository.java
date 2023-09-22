package com.osckorea.openmsa.admin.user.repository;

import org.springframework.data.repository.CrudRepository;
import com.osckorea.openmsa.admin.user.domain.User;

public interface UserRepository extends CrudRepository<User, String>, UserCustomRepository {
    
}

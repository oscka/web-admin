package com.osckorea.webadmin.starter.user.repository;

import java.util.UUID;

import com.osckorea.webadmin.starter.user.domain.User;

public interface UserRepositoryCustom {

    void deleteById(UUID id);

    void delete(User entity);
}

package com.osckorea.webAdmin.starter.user.repository;

import java.util.UUID;

import com.osckorea.webAdmin.starter.user.domain.User;

public interface UserRepositoryCustom {

    void deleteById(UUID id);

    void delete(User entity);
}

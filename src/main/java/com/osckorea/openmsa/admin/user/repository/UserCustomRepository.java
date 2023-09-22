package com.osckorea.openmsa.admin.user.repository;

import com.osckorea.openmsa.admin.user.domain.User;

public interface UserCustomRepository {
    User updateById(User user);
}

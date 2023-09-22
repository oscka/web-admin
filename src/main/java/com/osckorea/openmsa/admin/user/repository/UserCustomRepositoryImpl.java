package com.osckorea.openmsa.admin.user.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.osckorea.openmsa.admin.user.domain.User;
import com.osckorea.openmsa.admin.user.repository.sql.UserSql;
import com.osckorea.openmsa.admin.user.repository.util.UserCustomRowMapper;
import com.osckorea.openmsa.global.exception.Exception400;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository{
    private final UserCustomRowMapper userCustomRowMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User updateById(User user) {
        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(user);

        try {
            return this.namedParameterJdbcTemplate.queryForObject(UserSql.UPDATE_BY_ID, namedParameterSource, userCustomRowMapper);
        } catch (DataAccessException e) {
            throw new Exception400(user.getId(), "Not Exist User");
        }
    }
}

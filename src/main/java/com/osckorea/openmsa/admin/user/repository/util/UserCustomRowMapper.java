package com.osckorea.openmsa.admin.user.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.osckorea.openmsa.admin.user.domain.User;
import com.osckorea.openmsa.global.enums.UserRole;
import com.osckorea.openmsa.global.enums.UserStatus;

@Component
public class UserCustomRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                    .userId(rs.getString("user_id"))
                    .userPassword(rs.getString("user_password"))
                    .userName(rs.getString("user_name"))
                    .userStatus(UserStatus.valueOf(rs.getString("user_status")))
                    .userRole(UserRole.valueOf(rs.getString("user_role")))
                    .userEmail(rs.getString("user_email"))
                    .userPhoneNumber(rs.getString("user_phone_number"))
                    .createdDate(rs.getTimestamp("created_date"))
                    .modifiedDate(rs.getTimestamp("modified_date"))
                    .build();
    }
}

package com.osckorea.openmsa.admin.user.repository.sql;

public class UserSql {
    public static final String UPDATE_BY_ID = """
            UPDATE user
            SET user_password = :userPassword,
                user_name = :userName,
                user_email = :userEmail
            WHERE user_id = :userId
            """;
}

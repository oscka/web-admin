package com.osckorea.openmsa.admin.user.domain;

import java.sql.Timestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.osckorea.openmsa.admin.user.dto.UserDto;
import com.osckorea.openmsa.global.enums.UserRole;
import com.osckorea.openmsa.global.enums.UserStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table("user")
public class User implements Persistable<String>{
    @Id
    @Column("user_id")
    private String userId;

    @Column("user_password")
    private String userPassword;

    @Column("user_name")
    private String userName;

    @Column("user_status")
    private UserStatus userStatus;

    @Column("user_role")
    private UserRole userRole;

    @Column("user_email")
    private String userEmail;

    @Column("user_phone_number")
    private String userPhoneNumber;

    @CreatedDate
    @Column("created_date")
    private Timestamp createdDate;
    
    @LastModifiedDate
    @Column("modified_date")
    private Timestamp modifiedDate;

    @Setter
    @Transient
    @Builder.Default
    private boolean isNew = true;

    public String getId() {
        return this.userId;
    }

    public void ban() {
        this.userStatus = UserStatus.BAN;
    }
    
    public void lock() {
        this.userStatus = UserStatus.LOCKED;
    }

    public void delete() {
        this.userStatus = UserStatus.DELETED;
    }


    public UserDto.Response toDto() {
        return UserDto.Response.builder()
                                .id(this.userId)
                                .name(this.userName)
                                .status(this.userStatus)
                                .role(this.userRole)
                                .email(this.userEmail)
                                .phoneNumber(this.userPhoneNumber)
                                .createdDate(this.createdDate)
                                .modifiedDate(this.modifiedDate)
                                .build();
    }
}

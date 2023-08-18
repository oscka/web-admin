package com.osckorea.openmsa.admin.rolecontrol.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table("tb_user_info")
@Data
public class UserInfo {

    @Column("user_no")
    private Integer userNo;

    @Id
    @Column("user_id")
    private String userId;

    @Column("user_nm")
    private String userNm;

    @Column("user_pw")
    private String userPw;

    @Column("email")
    private String email;

    @Column("address")
    private String address;

    @Column("telphone")
    private String telphone;

    @Column("dept_no")
    private String deptNo;

    @Column("job")
    private String job;

    @Column("gender")
    private String gender;

    @Column("role_id")
    private List<String> roleId = new ArrayList<>();

    @Column("first_reg_id")
    private String firstRegId;

    @Column("first_reg_dt")
    private LocalDateTime firstRegDt;

    @Column("last_change_id")
    private String lastChangeId;

    @Column("last_change_dt")
    private LocalDateTime lastChangeDt;

    // Getters, setters, constructors, etc.
}


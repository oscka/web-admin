package com.osckorea.openmsa.global.domain;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.osckorea.openmsa.global.enums.UserRole;
import com.osckorea.openmsa.global.enums.UserStatus;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode(of = "id")
@Builder
@Getter
@ToString
@Table("user_tb")
public class User implements Serializable {

	@Id
	private UUID id;

	private String loginId;

	@Column("user_name")
	private String name;

	private UserStatus userStatus;

	@Column("user_role")
	private UserRole role;

	private String email;

	@Column("user_password")
	private String password;

	private String phone;

	@Builder.Default
	@CreatedDate
	private Instant createdAt = Instant.now();

	@Builder.Default
	@LastModifiedDate
	private Instant updatedAt = Instant.now();

	// ---------------- 비지니스 로직 --------------- //
	public void lock() {
		this.userStatus = UserStatus.LOCKED;
	}

	public void ban() {
		this.userStatus = UserStatus.BAN;
	}

	public void delete() {
		this.userStatus = UserStatus.DELETED;
	}


}
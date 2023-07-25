package com.osckorea.webAdmin.global.util.encrypt;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class EncryptString {
	@NotNull
	String value;
}

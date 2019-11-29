package com.payday.iam.api.models.v1;

public class LoginResponseDto {
	public LoginResponseDto(String token) {
		super();
		this.token = token;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

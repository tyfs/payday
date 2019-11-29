package com.payday.iam.api.models.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestDto {
    private String emailAddress;
    private String password;
	@JsonProperty("email_address")
	public String getEmailAddress() {
		return emailAddress;
	}
	@JsonProperty("email_address")
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

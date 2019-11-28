package com.payday.iam.api.models.v1;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserDto {
	private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    private String gender;
    private LocalDate dateOfBirth;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}
	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}
	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
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
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@JsonProperty("phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	@JsonProperty("phone_number")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@JsonProperty("date_of_birth")
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	@JsonProperty("date_of_birth")
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}

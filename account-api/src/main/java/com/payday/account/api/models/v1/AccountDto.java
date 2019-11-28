package com.payday.account.api.models.v1;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payday.account.domain.models.AccountStatus;
import com.payday.account.domain.models.AccountType;

public class AccountDto {
	private Long id;
	private Long userId;
	private AccountType type;
	private BigDecimal balance;
	private LocalDateTime createdAt;
	private AccountStatus status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonProperty("user_id")
	public Long getUserId() {
		return userId;
	}
	@JsonProperty("user_id")
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@JsonProperty("created_at")
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	@JsonProperty("created_at")
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}	
}

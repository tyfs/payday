package com.payday.account.api.models.v1;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDto {
	private Long id;
	private Long accountId;
	private LocalDateTime occurredAt;
	private String description;
	private BigDecimal amount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonProperty("account_id")
	public Long getAccountId() {
		return accountId;
	}
	@JsonProperty("account_id")
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	@JsonProperty("occurred_at")
	public LocalDateTime getOccurredAt() {
		return occurredAt;
	}
	@JsonProperty("occurred_at")
	public void setOccurredAt(LocalDateTime occurredAt) {
		this.occurredAt = occurredAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}

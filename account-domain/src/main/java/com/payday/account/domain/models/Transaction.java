package com.payday.account.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	@Column(name = "account_id")
	private Long accountId;
	@Column(name = "occurred_at", columnDefinition = "DateTime")
	private LocalDateTime occurredAt;
	private String description;
	private BigDecimal amount;
	
	public Transaction(Long accountId, LocalDateTime occurredAt, String description, BigDecimal amount) {
		super();
		this.accountId = accountId;
		this.occurredAt = occurredAt;
		this.description = description;
		this.amount = amount;
	}
	public Long getAccountId() {
		return accountId;
	}
	public Transaction() {
		super();
	}
	public Long getId() {
		return id;
	}
	public LocalDateTime getOccurredAt() {
		return occurredAt;
	}
	public String getDescription() {
		return description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
}

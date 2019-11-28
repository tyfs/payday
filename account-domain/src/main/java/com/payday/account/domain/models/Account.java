package com.payday.account.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	@Column(name = "user_id")
	private Long userId;	
	@Enumerated(EnumType.STRING)
	private AccountType type;
	private BigDecimal balance;
	@Column(name = "created_at", columnDefinition = "DateTime")
	private LocalDateTime createdAt;
	@Enumerated(EnumType.ORDINAL)
	private AccountStatus status;
	
	public Account(Long userId, AccountType type, BigDecimal balance, LocalDateTime createdAt, AccountStatus status) {
		super();
		this.userId = userId;
		this.type = type;
		this.balance = balance;
		this.createdAt = createdAt;
		this.status = status;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

	public Long getUserId() {
		return userId;
	}	

	public Long getId() {
		return id;
	}

	public AccountType getType() {
		return type;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public AccountStatus getStatus() {
		return status;
	}
}

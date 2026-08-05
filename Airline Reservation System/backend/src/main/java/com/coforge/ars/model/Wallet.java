package com.coforge.ars.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_wallet")
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer walletId;

	@NotNull(message = "Customer Id is mandatory")
	private Integer customerId;

	@NotNull(message = "Balance is mandatory")
	@DecimalMin(value = "0.0", message = "Balance cannot be negative")
	private BigDecimal balance;

	public Wallet() {
		super();
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", customerId=" + customerId + ", balance=" + balance + "]";
	}
	
	
}	

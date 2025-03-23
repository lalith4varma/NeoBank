package com.NeoBank.model;

import java.math.BigDecimal;

public class AccountModel {
	
	private String acctNum;
	private BigDecimal balance;
	
	public String getAcctNum() {
		return acctNum;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}

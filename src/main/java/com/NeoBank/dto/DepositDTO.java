package com.NeoBank.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.security.core.context.SecurityContextHolder;

public class DepositDTO {
	
	private String acctNum;
	private BigDecimal  amount;
	
	public DepositDTO() {
        this.acctNum = SecurityContextHolder.getContext().getAuthentication().getName();
    }
	
	public String getAcctNum() {
		return acctNum;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}

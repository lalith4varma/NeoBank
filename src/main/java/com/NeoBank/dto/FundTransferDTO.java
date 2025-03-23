package com.NeoBank.dto;

import java.math.BigDecimal;

import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.validation.constraints.Pattern;

public class FundTransferDTO {
	
	private String sourceAcct;
	@Pattern(regexp = "^\\d{12}$")
	private String destinationAcct;
	private BigDecimal amount;
	
	public FundTransferDTO() {
		this.sourceAcct = SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public String getSourceAcct() {
		return sourceAcct;
	}
	public String getDestinationAcct() {
		return destinationAcct;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setSourceAcct(String sourceAcct) {
		this.sourceAcct = sourceAcct;
	}
	public void setDestinationAcct(String destinationAcct) {
		this.destinationAcct = destinationAcct;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}

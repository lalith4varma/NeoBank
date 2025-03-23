package com.NeoBank.model;

public class TransactionsModel {
	
	private String type;
	private String amount;
	private String transactionDate;
	
	public String getType() {
		return type;
	}
	public String getAmount() {
		return amount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

}

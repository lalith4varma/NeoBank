package com.NeoBank.dao;

import java.math.BigDecimal;
import java.util.List;

import com.NeoBank.model.TransactionsModel;

public interface ServicesDAO {
	
	public BigDecimal viewBalance(String acctNum);
	public void editAccount(String acctNum, String name, String address, String contact);
	public void deposit(BigDecimal amt, String acctNum);
	public void transfer(String source, String destination, BigDecimal amt);
	public List<TransactionsModel> viewTransactions(String acctNum);
	public boolean userExists(String acctNum);
	
}

package com.NeoBank.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.NeoBank.dao.impl.ServicesDAOImpl;
import com.NeoBank.model.TransactionsModel;

@Service
public class BankServiceImpl {
	
	private ServicesDAOImpl services;
	
	public BankServiceImpl(ServicesDAOImpl services) {
		this.services = services;
	}
	
	public BigDecimal getBalance(String acctNum) {
		return services.viewBalance(acctNum);
	}
	
	public void editInfo(String acctNum, String name, String address, String contact) {
		services.editAccount(acctNum, name, address, contact);
	}
	
	public List<TransactionsModel> getTransactions(String acctNum) {
		return services.viewTransactions(acctNum);
	}
	
	public void deposit(BigDecimal amt, String acctNum) {
		services.deposit(amt, acctNum);
	}
	
	public void transfer(BigDecimal amt, String src, String destination){
		if (src.equals(destination)) throw new RuntimeException("Self-transfer not allowed");
		if (!services.userExists(destination)) throw new UsernameNotFoundException("Account Number not found");
		
		services.transfer(src, destination, amt);
	}
}

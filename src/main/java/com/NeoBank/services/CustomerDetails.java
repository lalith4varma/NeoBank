package com.NeoBank.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.NeoBank.model.CredentialsModel;
import com.NeoBank.model.CustomerModel;

@Service
public class CustomerDetails {
	
	public CustomerModel getDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CredentialsModel credDao = (CredentialsModel) authentication.getPrincipal();
		
		return credDao.getCustDao();
	}
	
	public String getAcctNum() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	public void updateName(CustomerModel cust) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CredentialsModel credDao = (CredentialsModel) authentication.getPrincipal();
		
		credDao.setCustDao(cust);
	}
}

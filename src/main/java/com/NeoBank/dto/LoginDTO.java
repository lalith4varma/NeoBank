package com.NeoBank.dto;

public class LoginDTO {

	private String acctNum;
	private String password;
	
	public String getAcctNum() {
		return acctNum;
	}
	public String getPassword() {
		return password;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

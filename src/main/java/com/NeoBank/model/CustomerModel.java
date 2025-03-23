package com.NeoBank.model;

public class CustomerModel {
	
	private String name;
	private String address;
	private String contact;
	private String acctNum;
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getContact() {
		return contact;
	}
	public String getAcctNum() {
		return acctNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

}

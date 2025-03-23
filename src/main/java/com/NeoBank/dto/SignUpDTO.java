package com.NeoBank.dto;

import com.NeoBank.custom_validator.PasswordMatch;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@PasswordMatch(firstFieldName = "password", secondFieldName = "confirmPassword")
public class SignUpDTO {
	
	@NotBlank
	@Size(min = 12, max = 12)
	private String acctNum;
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	private String password;
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	private String confirmPassword;
	
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}

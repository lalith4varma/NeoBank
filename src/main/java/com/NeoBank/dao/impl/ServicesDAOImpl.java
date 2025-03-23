package com.NeoBank.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.NeoBank.dao.ServicesDAO;
import com.NeoBank.model.TransactionsModel;

@Repository
public class ServicesDAOImpl implements ServicesDAO{
	
	private final JdbcTemplate jdbcTemplate;
	private final String currentBalance = "SELECT balance FROM account WHERE account_number = ?";
	private final String viewTransaction = "SELECT transaction_type as type, amount, transaction_date as transactionDate FROM transaction WHERE account_number = ?";
	private final String updateCustomerInfo = "UPDATE customer SET name = ?, address = ?, contact_number = ? WHERE account_number = ?";
	private final String updateCustomerInfoTransaction = "INSERT INTO transaction (account_number,transaction_type) VALUES (?,?)";
	private final String deposit = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
	private final String depositTransaction = "INSERT INTO transaction (account_number,transaction_type, amount) VALUES (?,?,?)";
	private final String transferSender = "UPDATE account SET balance = balance - ? WHERE account_number = ?";
	private final String checkUser = "SELECT count(*) FROM account WHERE account_number = ?";
	
	public ServicesDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	@Override
	public void editAccount(String acctNum, String name, String address, String contact) {
		jdbcTemplate.update(updateCustomerInfo, name, address, contact, acctNum);
		jdbcTemplate.update(updateCustomerInfoTransaction, acctNum,"edit_profile");
	}

	@Transactional
	@Override
	public void deposit(BigDecimal amount, String acctNum) {
		jdbcTemplate.update(deposit, amount, acctNum);
		jdbcTemplate.update(depositTransaction, acctNum, "deposit", amount);
	}

	@Transactional
	@Override
	public void transfer(String source, String destination, BigDecimal amt) {
		// Update balance for both sender and receiver
		jdbcTemplate.update(transferSender, amt, source);
		jdbcTemplate.update(deposit, amt, destination);
		
		// Record transaction for both sender and receiver
		jdbcTemplate.update(depositTransaction, source, "transfer", amt.negate());
		jdbcTemplate.update(depositTransaction, destination, "transfer", amt);
	}

	@Transactional(readOnly = true)
	@Override
	public List<TransactionsModel> viewTransactions(String acctNum) {
		List<TransactionsModel> transactions = jdbcTemplate.query(viewTransaction, new BeanPropertyRowMapper<>(TransactionsModel.class), acctNum);
		
		return transactions;
	}

	@Transactional(readOnly = true)
	@Override
	public BigDecimal viewBalance(String acctNum) {
		return jdbcTemplate.queryForObject(currentBalance, BigDecimal.class, acctNum);
	}
	
	@Transactional(readOnly = true)
	@Override
	public boolean userExists(String acctNum) {
		return (jdbcTemplate.queryForObject(checkUser, Integer.class, acctNum) > 0);
	}	
}

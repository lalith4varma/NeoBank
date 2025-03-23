package com.NeoBank.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NeoBank.model.CredentialsModel;
import com.NeoBank.model.CustomerModel;

@Transactional
@Service
public class UserDetailsImpl implements UserDetailsService, UserDetailsManager{
	
	private final JdbcTemplate jdbcTemplate;
	
	public UserDetailsImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private final String checkUserExist = "SELECT count(*) FROM account WHERE account_number = ?";
	private final String createUserAcct = "INSERT INTO account (account_number) VALUES (?)";
	private final String createUserCred = "INSERT INTO credentials (password, account_number, authority) VALUES (?,?,?)";
	private final String createUserDetails = "INSERT INTO customer (account_number) VALUES (?)";
	private final String createRegistrationrecord = "INSERT INTO transaction (account_number, transaction_type) VALUES (?,?)";
	private final String queryCreds = "SELECT password, account_number as acctNum, authority as role FROM credentials WHERE account_number = ?";
	private final String queryCustomerDetails = "SELECT name, address, contact_number as contact FROM customer WHERE account_number = ?";
	
	@Override
	public void createUser(UserDetails user) {
		
		if (userExists(user.getUsername())) {
			throw new DataIntegrityViolationException("Error.duplicate.account");
		}
		
		String auth = user
				.getAuthorities()
				.stream()
				.map(authority -> authority
						.getAuthority())
				.reduce((role1, role2) -> role1 + "," + role2)
				.orElse("");
		
		jdbcTemplate.update(createUserAcct, user.getUsername());
		jdbcTemplate.update(createUserCred, user.getPassword(), user.getUsername(), auth);
		jdbcTemplate.update(createUserDetails, user.getUsername());
		jdbcTemplate.update(createRegistrationrecord, user.getUsername(),"registration");
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		
		int count = jdbcTemplate.queryForObject(checkUserExist, Integer.class, username);
		
		return count > 0;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Spring Security will convert UsernameNotFoundException to BadCredentialsException
		// This is to prevent hackers from guessing valid user account names
		if (!userExists(username)) throw new UsernameNotFoundException("");
		
		CredentialsModel getUser = jdbcTemplate.queryForObject(queryCreds, new BeanPropertyRowMapper<>(CredentialsModel.class), username);
		CustomerModel custDao = jdbcTemplate.queryForObject(queryCustomerDetails, new BeanPropertyRowMapper<>(CustomerModel.class), username);
		
		getUser.setCustDao(custDao);
		
//		UserDetails existingUser = User
//				.withUsername(getUser.getAcctNum())
//				.password(getUser.getPassword())
//				//.roles(getUser.get(0).getRole()) //--> prepends "ROLE_" to each role passed to it
//				.authorities(getUser.getRole()) // --> accepts each role without prepending anything
//				.build();
		
		return getUser;
	}

}

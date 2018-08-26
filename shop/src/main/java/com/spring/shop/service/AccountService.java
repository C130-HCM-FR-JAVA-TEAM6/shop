package com.spring.shop.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.shop.model.Account;
import com.spring.shop.model.Role;
import com.spring.shop.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public Account updateAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account findById(long accountId) {
		return accountRepository.findById(accountId).get();
	}

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account checkLogin(String username, String password) {
		Account account = accountRepository.findByUserNameAndPassword(username, password);
		return account;
	}

	public void save(Account account) {
		accountRepository.save(account);
	}

	public Account loadUserByUsername(String username) {
		return accountRepository.findByUserName(username);
	}
	
	public List<GrantedAuthority> getAuthorities(Account account) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		System.out.println("quyen ne: " + account.getRole().getRoleName());
		authorities.add(new SimpleGrantedAuthority(account.getRole().getRoleName()));
		return authorities;
	}
}

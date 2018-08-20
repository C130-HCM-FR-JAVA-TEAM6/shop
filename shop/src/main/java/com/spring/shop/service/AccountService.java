package com.spring.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.repository.AccountRepository;
import com.spring.shop.model.Account;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	public List<Account> getAllAccount(){
		return accountRepository.findAll();
	}
	
	public Account checkLogin(String username,String password) {
		Account account = accountRepository.findByUserNameAndPassword(username,password);
		return account;
	}
}

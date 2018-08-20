package com.spring.shop.controller;

import java.util.List;
import com.spring.shop.model.Account;
import com.spring.shop.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/api")
	public List<Account> account(){
		return accountService.getAllAccount();
		
	}
	@RequestMapping("/login/{username}/{password}")
	public Account login(@PathVariable("username") String username,@PathVariable("password") String password) {
		return accountService.checkLogin(username, password);
	}
}

package com.spring.shop.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shop.filter.JwtService;
import com.spring.shop.model.Account;
import com.spring.shop.service.AccountService;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	  @Autowired
	  private JwtService jwtService;
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
//	@RequestMapping("/login/{username}/{password}")
//	public Account login(@PathVariable("username") String username,@PathVariable("password") String password) {
//		Account account =  accountService.checkLogin(username, password);
//		if(account != null) {
//			return account;
//		}
//		return null;
//	}
	
//	@GetMapping("/login")
//	public Principal login(Principal account) {
//		return account;
//	}
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Account account) {
		System.out.println(account.getUserName()+" - "+account.getPassword());
		account = accountService.checkLogin(account.getUserName(), account.getPassword());
		String token = jwtService.generateTokenLogin(account.getUserName());
		Map<String, Object> map = new HashMap<>();
		map.put("account", account);
		map.put("token", token);
		return map;
	}
	  

//		@Pre
//	@PreAuthorize("hasRole('admin')")
	@RequestMapping(value = "/addAccount",method = RequestMethod.POST)
	public ResponseEntity<?> addAccount(@RequestBody Account account) {
		accountService.save(account);
		return new ResponseEntity<Account>(account,HttpStatus.CREATED);
		
	}
//	@PreAuthorize("hasRole('admin')")
	@RequestMapping(value = "/getAccount",method = RequestMethod.GET)
	public List<Account> getAccount() {
		return accountService.findAll();
		
	}
	@RequestMapping(value = "/getAccount",method = RequestMethod.POST)
	public List<Account> getAllAccount() {
		return accountService.findAll();
		
	}
	@RequestMapping(value = "/updateAccount",method = RequestMethod.POST)
	public ResponseEntity<?> updateAccount(@RequestBody Account account){
		accountService.updateAccount(account);
		return new ResponseEntity<Account>(account,HttpStatus.ACCEPTED);
		
	}
	
	
}
